package org.practise.leetcode_dailies;

public class LC_3453 {
    public double separateSquares(int[][] squares) {
        double minY = getMinY(squares);
        double maxY = getMaxY(squares);
        double precision = 1e-5;

        while (maxY - minY > precision) {
            double midY = (minY + maxY) / 2;
            if (isLowerHalfLarger(squares, midY)) {
                maxY = midY;
            } else {
                minY = midY;
            }
        }
        return minY;
    }

    private boolean isLowerHalfLarger(int[][] squares, double midY) {
        double lowerArea = 0, upperArea = 0;
        for(int[] square: squares) {
            double bottomY = square[1], side = square[2], topY = bottomY + side;

            if (topY <= midY) {
                lowerArea += side * side;
            } else if (bottomY >= midY) {
                upperArea += side * side;
            } else {
                double below = midY - bottomY, above = topY - midY;
                lowerArea += below * side;
                upperArea += above * side;
            }
        }
        return lowerArea >= upperArea;
    }

    private double getMaxY(int[][] squares) {
        double maxY = squares[0][1];
        for(int[] square: squares) {
            maxY = Math.max(maxY, (square[1] + square[2])*1.0);
        }
        return maxY;
    }

    private double getMinY(int[][] squares) {
        double minY = squares[0][1];
        for(int[] square: squares) {
            minY = Math.min(minY, square[1]*1.0);
        }
        return minY;
    }


}
