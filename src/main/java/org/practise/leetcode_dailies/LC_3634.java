package org.practise.leetcode_dailies;

import java.util.Arrays;

public class LC_3634 {

    public static void main(String[] args) {
        LC_3634 ref = new LC_3634();
        int[] nums = {2, 1, 5};
        int k = 2;
        System.out.println(ref.minRemoval_apporach2(nums, k));
    }

    //    3634. Minimum Removals to Balance Array
    /*
    * below solution is wrong for:
    * *[1,34,23] and k = 2;
        we can only remove 1 and then it will be balanced
    * **/
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        int longest = Integer.MIN_VALUE;

        if (n < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int currentLength = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] <= (k * nums[0])) {
                currentLength = 0;
            } else {
                currentLength += 1;
            }
            longest = Math.max(currentLength, longest);
        }

        return longest;
    }

    //    using 2 pointer and sliding window
    public int minRemoval_apporach2(int[] nums, int k) {
        int n = nums.length;

        // sort
        Arrays.sort(nums);

        int maxLen = 1;
        int i = 0;

        // find the longest valid (balanced) subarray
        // expand
        for (int j = 0; j < n; j++) {
            long minE = nums[i];
            long maxE = nums[j];

            //shrink
            while (i < j && (maxE > k * minE)) {
                i++;
                minE = nums[i];
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        // len of array - largest balance array
        return n - maxLen;
    }

}
