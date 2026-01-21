package org.practise.leetcode_dailies;

import java.util.*;

public class LC_3454 {

    class event {double y;
        int type;
        int xStart;
        int xEnd;

        event(double y, int type, int xStart, int xEnd) {
            this.y = y;
            this.type = type;
            this.xStart = xStart;
            this.xEnd = xEnd;
        }
    }

    public double separateSquares(int[][] squares) {

        List<event> events = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int[] sq : squares) {
            int x = sq[0];
            int y = sq[1];
            int size = sq[2];

            events.add(new event(y, 1, x, x + size));
            events.add(new event(y + size, -1, x, x + size));

            set.add(x);
            set.add(x + size);
        }
        int n = set.size();
        int x[] = new int[n]; int p = 0;
        for(int num: set){
            x[p] = num;
            p++;
        }
        Arrays.sort(x);

        events.sort(Comparator.comparingDouble(e -> e.y));

        int[] coverCount = new int[4 * n];
        double[] coveredLength = new double[4 * n];

        double totalArea = 0;
        double prevY = events.get(0).y;

        List<double[]> parts = new ArrayList<>();

        int i = 0;
        while (i < events.size()) {
            double currY = events.get(i).y;

            if (currY > prevY) {
                double height = currY - prevY;
                double width = coveredLength[1];
                totalArea += width * height;
                parts.add(new double[]{prevY, currY, width});
                prevY = currY;
            }

            while (i < events.size() && events.get(i).y == currY) {
                event e = events.get(i);
                int left = Arrays.binarySearch(x, e.xStart);
                int right = Arrays.binarySearch(x, e.xEnd);
                updateTree(1, 0, n, left, right, e.type, x, coverCount, coveredLength);
                i++;
            }
        }

        double half = totalArea / 2;
        double sum = 0;

        for (double[] part : parts) {
            double y1 = part[0];
            double y2 = part[1];
            double width = part[2];

            double area = width * (y2 - y1);

            if (sum + area >= half) {
                return y1 + (half - sum) / width;
            }
            sum += area;
        }

        return prevY;
    }
    public void updateTree(int node, int start, int end, int left, int right, int value, int[] x, int[] coverCount, double[] coveredLength) {
        if (right <= start || end <= left) return;

        if (left <= start && end <= right) {
            coverCount[node] += value;
        } else {
            int mid = (start + end) / 2;
            updateTree(node * 2, start, mid, left, right, value, x, coverCount, coveredLength);
            updateTree(node * 2 + 1, mid, end, left, right, value, x, coverCount, coveredLength);
        }

        if (coverCount[node] > 0) {
            coveredLength[node] = x[end] - x[start];
        } else {
            if (end - start == 1) {
                coveredLength[node] = 0;
            } else {
                coveredLength[node] =
                        coveredLength[node * 2] + coveredLength[node * 2 + 1];
            }
        }
    }

}
