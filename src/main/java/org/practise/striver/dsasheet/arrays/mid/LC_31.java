package org.practise.striver.dsasheet.arrays.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC_31 {

    //    31. Next Permutation

    public static void main(String[] args) {
        LC_31 ref = new LC_31();
        int[] nums = {3,2,1};
        ref.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        int pivot = longestNonIncreasingSuffix(nums) -1;
        if(pivot != -1) {
            int rightPrefix = rightMostSuccessor(nums, pivot);
            swap(nums, pivot, rightPrefix);
        }
        reverseSuffix(nums, pivot+1, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public int longestNonIncreasingSuffix(int[] nums) {
        for(int i=nums.length-1; i>0; i--) {
            if(nums[i-1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }

    public int rightMostSuccessor(int[] nums, int pivot) {
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] > nums[pivot]) {
                return i;
            }
        }
        return -1;
    }

    public void reverseSuffix(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
