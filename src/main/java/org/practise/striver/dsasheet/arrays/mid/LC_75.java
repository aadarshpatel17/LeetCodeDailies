package org.practise.striver.dsasheet.arrays.mid;

public class LC_75 {

//    75. Sort Colors
    // we will use 3 pointers technique here
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1, mid = 0;
        while(mid <= right) {
            if(nums[mid] == 0) {
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                mid++;
                left++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = temp;
                right--;
            }
        }
    }

}
