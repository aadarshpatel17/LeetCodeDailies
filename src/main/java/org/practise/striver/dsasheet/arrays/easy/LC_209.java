package org.practise.striver.dsasheet.arrays.easy;

public class LC_209 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int[] nums1 = {10, 5, 2, 7, 1, 9};
        int target1 = 15;
        int[] nums2 = {-1, 1, 1};
        int target2 = 1;
        LC_209 refernce = new LC_209();
        System.out.println(refernce.minSubArrayLen(target, nums));
        System.out.println(refernce.maxSubArrayLen(target2, nums2));
    }

    //    209. Minimum Size Subarray Sum
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

    public int maxSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int maxLen = 0;
        int sum = 0;
        while(right < n) {
            sum += nums[right];
            while(sum >= target) {
                if(sum == target) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return maxLen;
    }

}
