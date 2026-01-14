package org.practise.codewitharyansheet.array.easy;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}
