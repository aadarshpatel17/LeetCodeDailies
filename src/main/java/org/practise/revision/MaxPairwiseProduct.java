package org.practise.revision;

import java.util.Arrays;

public class MaxPairwiseProduct {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int[] nums2 = {1, 2};
        System.out.println(maxPairProduct(nums));
        System.out.println(maxPairProduct_correct(nums));
        System.out.println(maxPairwiseProductUsingSorting(nums));
    }

    /*
     * this will work fine with {1,2} output: 2, however for {2,1} output will be 4
     * because we are starting index as 0;
     * **/
    public static int maxPairProduct(int[] nums) {
        int n = nums.length;
        int index1 = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[index1]) {
                index1 = i;
            }
        }
        int index2 = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[index1] && nums[i] > nums[index2]) {
                index2 = i;
            }
        }
        return nums[index1] * nums[index2];
    }

    /* correct approach */
    public static int maxPairProduct_correct(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
//        swap
        swap(nums, index, n - 1);

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
//        swap
        swap(nums, index, n - 2);

        return nums[n - 1] * nums[n - 2];
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // a more compact algo will be using sorting
    public static int maxPairwiseProductUsingSorting(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - 1] * nums[n - 2];
    }

}
