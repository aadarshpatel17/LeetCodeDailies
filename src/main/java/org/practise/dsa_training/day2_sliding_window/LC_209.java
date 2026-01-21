package org.practise.dsa_training.day2_sliding_window;

public class LC_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for(int right = 0; right < n; right++) {
            sum += nums[right];
            while(sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0: minLen;
    }

}
