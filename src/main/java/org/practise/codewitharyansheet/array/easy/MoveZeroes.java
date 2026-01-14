package org.practise.codewitharyansheet.array.easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        for(int right=0; right<n; right++) {
            if(nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        while(left < n) {
            nums[left++] = 0;
        }
    }
}
