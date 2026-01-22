package org.practise.leetcode_dailies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_3507 {

    //    3507. Minimum Pair Removal to Sort Array I
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        // LNDS using DP (since constraints are small)
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int lnds = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lnds = Math.max(lnds, dp[i]);
        }

        int removeCount = n - lnds;
        return (removeCount + 1) / 2; // ceil(removeCount / 2)
    }

}
