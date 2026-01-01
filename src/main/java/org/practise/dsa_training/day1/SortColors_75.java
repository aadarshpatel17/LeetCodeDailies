package org.practise.dsa_training.day1;

public class SortColors_75 {

//    wrong solution:
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            if(nums[left] > nums[right]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                left++;
            }
        }
    }

    public void sortColors_threePointer(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        while(mid <= high) {
            if(nums[mid] == 0) {
                // swap mid and low
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                // just increment mid
                mid++;
            } else {
                // swap mid and high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

}
