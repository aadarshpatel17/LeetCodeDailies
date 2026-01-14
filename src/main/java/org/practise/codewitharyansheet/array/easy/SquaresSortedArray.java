package org.practise.codewitharyansheet.array.easy;

public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1, pos = n-1;
        int[] result = new int[n];
        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[pos--] = nums[left] * nums[left];
                left++;
            } else {
                result[pos--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
