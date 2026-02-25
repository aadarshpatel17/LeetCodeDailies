package org.practise.leetcode_dailies;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC_1356 {

    // 1356. Sort Integers by The Number of 1 Bits

    public static void main(String[] args) {
        int[] nums = {1024,512,256,128,64,32,16,8,4,2,1};
        System.out.println(Arrays.toString(sortByBits_right_approach(nums)));
    }

    public static int[] sortByBits_right_approach(int[] nums) {
        int n = nums.length;

        Integer[] boxedArray = new Integer[n];

        for(int i=0; i<n; i++) {
            boxedArray[i] = nums[i];
        }

        Arrays.sort(boxedArray, (a,b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if(countA == countB) {
                return a.compareTo(b);
            }
            return Integer.compare(countA, countB);
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedArray[i];
        }

        return nums;
    }

    public static int[] sortByBits(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                result[i] = 0;
                continue;
            }
            result[i] = Integer.bitCount(nums[i]);
        }
        return sort(nums, result);
    }

    public static int[] sort(int[] nums, int[] result) {
        int i=nums.length-1;
        int[] nums1 = new int[nums.length];

        for(int j=0; j<result.length; j++) {
            int maxIndex = max(result);
            nums1[i--] = nums[maxIndex];
        }
        return nums1;
    }

    public static int max(int[] result) {
        System.out.println(Arrays.toString(result));
        int maxIndex = result.length-1;
        for(int i=result.length-2; i>=0; i--) {
            if(result[maxIndex] < result[i]) {
                maxIndex = i;
            }
        }
        result[maxIndex] = -1;
        System.out.println(Arrays.toString(result));
        return maxIndex;
    }

}
