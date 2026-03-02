package org.practise.leetcode_dailies;

import java.util.ArrayList;
import java.util.List;

import static org.practise.revision.Revision_17_02_2026.swap;

public class LC_1536 {

    // LC_1536. Minimum Swaps to Arrange a Binary Grid

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1}, {1, 1, 0}, {1, 0, 0}};
        System.out.println(minSwaps(grid));
    }
    
    public static int minSwaps(int[][] grid) {
        int n = grid.length; // n == columns
        int steps = 0;

        // 1. find how many endZeros each row has from the end and store it in an array
        int[] endZeros = new int[n];
        for (int i = 0; i < n; i++) {
            int j = n - 1; // start from end
            int count = 0;
            while (j >= 0 && grid[i][j] == 0) {
                count++;
                j--;
            }
            endZeros[i] = count;
        }

        for (int i = 0; i < n; i++) {
            int need = n - i - 1;
            int j = i;
            // 2. check how many endZeros we require (n - row - 1)
            while (j < n && endZeros[j] < need) {
                j++;
            }

            // return -1, if endZeros array didn't contains need;
            if (j == n) {
                return -1;
            }

            steps += j - i;

            while (j > i) {
                int temp = endZeros[j];
                endZeros[j] = endZeros[j - 1];
                endZeros[j - 1] = temp;
                j--;
            }
        }

        return steps;
    }


}
