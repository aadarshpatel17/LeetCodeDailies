package org.practise.leetcode_dailies;

import java.util.Arrays;

public class LC_1877 {

//    1877. Minimize Maximum Pair Sum in Array

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int max = Integer.MIN_VALUE;
        while(left < right) {
            int sum = nums[left] + nums[right];
            max = Math.max(sum ,max);
            left++; right--;
        }
        return max;
    }
}
