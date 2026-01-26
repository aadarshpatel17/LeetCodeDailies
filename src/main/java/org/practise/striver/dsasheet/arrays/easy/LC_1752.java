package org.practise.striver.dsasheet.arrays.easy;

public class LC_1752 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        LC_1752 reference = new LC_1752();
        System.out.println(reference.check(nums));
    }

    //    1752. Check if Array Is Sorted and Rotated
    public boolean check(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return true;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
        }
        if(nums[n-1] > nums[0]) {
            count++;
        }
        return count <= 1;
    }


}
