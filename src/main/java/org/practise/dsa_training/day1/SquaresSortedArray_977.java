package org.practise.dsa_training.day1;

import java.util.Arrays;

public class SquaresSortedArray_977 {

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            res[i] = Math.abs(nums[i] * nums[i]);
        }
        Arrays.sort(res);
        return res;
    }

    public int[] sortedSquares_usingTwoPointers(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n-1, pos = n-1;
        while(left <= right) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[pos--] = Math.abs(nums[right] * nums[right]);
                right--;
            } else {
                res[pos--] = Math.abs(nums[left] * nums[left]);
                left++;
            }
        }
        return res;
    }

}
