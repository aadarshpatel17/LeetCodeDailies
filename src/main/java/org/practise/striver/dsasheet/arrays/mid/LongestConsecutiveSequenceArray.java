package org.practise.striver.dsasheet.arrays.mid;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceArray {
    //    Longest Consecutive Sequence in an Array

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        for(int i=0; i<n; i++) {
            int len = 0;
            if(!set.contains(nums[i] - 1)) {
                len++;
                while(set.contains(nums[i] + len)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
