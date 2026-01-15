package org.practise.dsa_training.day8;

public class LC_2091 {

    public int minimumDeletions(int[] nums) {
        // Step 1: find indices of min and max values
        int n = nums.length;
        int iMin = -1, iMax = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                iMin = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                iMax = i;
            }
        }

        // Step 2: compute the four possible deletion counts
        int leftBoth = Math.max(iMax, iMin) + 1;
        int rightBoth = n - Math.min(iMin, iMax);
        int leftMinRightMax = (iMin + 1) + (n - iMax);
        int leftMaxRightMin = (iMax + 1) + (n - iMin);

        int ans = Math.min(leftBoth, rightBoth);
        ans = Math.min(ans, leftMaxRightMin);
        ans = Math.min(ans, leftMinRightMax);

        return ans;
    }

}
