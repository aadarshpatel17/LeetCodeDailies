package org.practise.leetcode_dailies;

import java.util.List;

public class LC_3314 {

    //    3314. Construct the Minimum Bitwise Array I
    public int[] minBitwiseArray_Optimize(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean found = false;
            int x = -1;
            if (nums.get(i) % 2 == 0) {
                ans[i] = -1;
            } else {
                for (int j = 0; j < 32; j++) {
                    if ((nums.get(i) & (1 << j)) > 0) {
                        continue;
                    }
                    int prev = j - 1;
                    // make prev bit (j-1) zero;
                    x = (nums.get(i) ^ (1 << prev));
                    found = true;
                    break;
                }
                if(found) {
                    ans[i] = x;
                }
            }
        }
        return ans;
    }

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
