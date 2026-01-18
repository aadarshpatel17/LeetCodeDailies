package org.practise.leetcode_dailies;

public class LC_3047 {
    // 3047. Find the Largest Area of Square Inside Two Rectangles
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                long left   = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                long right  = Math.min(topRight[i][0], topRight[j][0]);
                long top    = Math.min(topRight[i][1], topRight[j][1]);

                if (left < right && bottom < top) {
                    long side = Math.min(right - left, top - bottom);
                    maxArea = Math.max(maxArea, side * side);
                }
            }
        }
        return maxArea;
    }
}
