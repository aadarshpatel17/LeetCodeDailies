package org.practise.dailyLC._01_jan;

import java.util.Arrays;

public class LC_25 {

    // 1984. Minimum Difference Between Highest and Lowest of K Scores
    public int minimumDifference(int[] nums, int k) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i+k-1<nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i+k-1] - nums[i]);
        }
        return minDiff;
    }

}
