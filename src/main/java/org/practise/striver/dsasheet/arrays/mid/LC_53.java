package org.practise.striver.dsasheet.arrays.mid;

public class LC_53 {

    //    53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int max = (int )Double.NEGATIVE_INFINITY;
        int sum = 0;
        for(int num: nums) {
            sum += num;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }

}
