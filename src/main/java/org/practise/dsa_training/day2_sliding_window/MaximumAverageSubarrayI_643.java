package org.practise.dsa_training.day2_sliding_window;

public class MaximumAverageSubarrayI_643 {
    // brute force
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        for(int i=0; i<nums.length-k; i++) {
            int sum = 0;
            for(int j=i; j<=i+k; j++) {
                sum += nums[j];
            }
            double avg = (double) sum/k;
            maxAvg = Math.max(avg, maxAvg);
        }
        return maxAvg;
    }

    // using sliding window
    public double findMaxAverage_optimize(int[] nums, int k) {
        int sum = 0, maxSum = 0;
        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for(int i=k; i<nums.length; i++) {
            sum += nums[i];
            sum -= nums[i-k];
            maxSum = Math.max(sum, maxSum);
        }
        return (double) maxSum/k;
    }

}
