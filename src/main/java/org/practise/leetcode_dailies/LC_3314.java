package org.practise.leetcode_dailies;

import java.util.List;

public class LC_3314 {

    //    3314. Construct the Minimum Bitwise Array I
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = minBitwise(nums.get(i));
        }
        return ans;
    }

    public int minBitwise(int n) {
        for (int i = 0; i < n; i++) {
            if ((i | i + 1) == n) {
                return i;
            }
        }
        return -1;
    }
}
