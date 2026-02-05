package org.practise.leetcode_dailies;

import java.util.Arrays;

public class LC_3379 {

    public static void main(String[] args) {
        int[] nums = {-1,4,-1};
        LC_3379 ref = new LC_3379();
        System.out.println(Arrays.toString(ref.constructTransformedArray_optimize(nums)));
    }

//    3379. Transformed Array
    public int[] constructTransformedArray_optimize(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = nums[((nums[i] + i) % n + n) % n];  // (new_index % n + n) % n;
        }
        return result;
    }

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            if(nums[i] < 0) {
                // todo
                int index = nums[i] + i;
                while(index < 0) {
                    index = index + n;
                }
            } else if(nums[i] > 0) {
                int index = nums[i] + i;
                index = (index >= n) ? index % n: index;
                result[i] = nums[index];
            } else {
                result[i] = nums[i];
            }
        }
        return result;
    }
}
