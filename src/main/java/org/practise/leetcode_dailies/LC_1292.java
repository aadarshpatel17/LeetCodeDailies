package org.practise.leetcode_dailies;

public class LC_1292 {

    // 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // Prefix sum array
        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                        + pre[i - 1][j]
                        + pre[i][j - 1]
                        - pre[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);

        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (existsSquare(pre, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean existsSquare(int[][] pre, int k, int threshold) {
        if (k == 0) return true;

        int m = pre.length - 1;
        int n = pre[0].length - 1;

        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                int sum = pre[i][j]
                        - pre[i - k][j]
                        - pre[i][j - k]
                        + pre[i - k][j - k];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
