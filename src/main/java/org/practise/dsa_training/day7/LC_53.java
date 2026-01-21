package org.practise.dsa_training.day7;

public class LC_53 {

    public int maxSubArray(int[] nums) {
        int max = (int ) Double.NEGATIVE_INFINITY;
        int sum = 0;
        for(int num: nums) {
            sum += num;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxProduct = nums[0];

        for(int i=1; i<nums.length; i++) {
            int curr = nums[i];
            if(curr < 0) {
                // swap min and max
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(curr, curr * maxSoFar);
            minSoFar = Math.min(curr, curr * minSoFar);
            maxProduct = Math.max(maxProduct, maxSoFar);
        }

        return maxProduct;
    }

}
