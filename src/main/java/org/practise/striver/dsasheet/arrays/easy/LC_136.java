package org.practise.striver.dsasheet.arrays.easy;

public class LC_136 {

    //    136. Single Number
    public int singleNumber(int[] nums) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            number ^= nums[i];
        }
        return number;
    }

}
