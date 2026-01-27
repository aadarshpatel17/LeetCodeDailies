package org.practise.striver.dsasheet.arrays.mid;

import java.util.Arrays;

public class LC_2149 {

    public static void main(String[] args) {
//        int[] nums = {28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31};
        int[] nums = {3,1,-2,-5,2,-4};
//        int[] nums = {1, 2, -1, -2};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }


    //    2149. Rearrange Array Elements by Sign
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;
        int[] result = new int[n];
        for(int num: nums) {
            if(left < n && num > 0) {
                result[left] = num;
                left += 2;
            }
            if(right < n && num < 0) {
                result[right] = num;
                right += 2;
            }
        }

        return result;
    }


}
