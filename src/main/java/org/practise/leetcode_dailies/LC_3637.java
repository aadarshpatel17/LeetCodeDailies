package org.practise.leetcode_dailies;

public class LC_3637 {

    //    3637. Trionic Array I
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;
        // increasing
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) {
            return false;
        }

        // decreasing
        while (i < n - 1 && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return false;
        }

        // increasing
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }

        if (i == n - 1) {
            return true;
        } else {
            return false;
        }
    }

}
