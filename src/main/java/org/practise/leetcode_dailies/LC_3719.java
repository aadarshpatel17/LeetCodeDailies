package org.practise.leetcode_dailies;

import java.util.HashSet;
import java.util.Set;

public class LC_3719 {

    // LC_3719. Longest Balanced Subarray I
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for(int i=0; i<n; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for(int j=i; j<n; j++) {
                if(nums[j] % 2 == 0) {
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }

                if(even.size() == odd.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

}
