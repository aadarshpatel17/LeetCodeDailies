package org.practise.leetcode_dailies;

public class LC_799 {
    // 799. Champagne Tower

    double[][] t = new double[101][101];

    public double champagneTower(int poured, int query_row, int query_glass) {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                t[i][j] = -1;
            }
        }
        return Math.min(1.0, solve(poured, query_row, query_glass));
    }

    public double solve(int poured, int i, int j) {
        if (i < 0 || j > i || j < 0) {
            return 0.0;
        }

        // base condition
        if (i == 0 && j == 0) {
            return t[i][j] = poured;
        }

        //memo
        if (t[i][j] != -1) {
            return t[i][j];
        }

        // recursion
        double up_left = (solve(poured, i - 1, j - 1) - 1) / 2.0;
        double up_right = (solve(poured, i - 1, j) - 1) / 2.0;

        if(up_left < 0) {
            return 0.0;
        }
        if(up_right < 0) {
            return 0.0;
        }

        return t[i][j] = up_left + up_right;
    }

}
