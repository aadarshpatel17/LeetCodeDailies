package org.practise.dsa_training.day1_2pointer;

public class LC_26 {

    // 1,2,2,3,2 : works fine but there is an issue, 1,2,3,2,2 this will be in-place array
    // work fine for sorted array
    public int removeDuplicates(int[] nums) {
        if(nums.length < 1) {
            return 0;
        }
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    // 1,2,2,3,2 : works fine
    public int removeDuplicates_worksWithUnsortedAsWell(int[] nums) {
        if(nums.length < 1) {
            return 0;
        }
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

}
