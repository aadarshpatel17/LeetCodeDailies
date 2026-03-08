package org.practise.contest;

public class LC_08_03_2026 {

    public static void main(String[] args) {
        int[] nums = {2, 8, 2, 2, 5};
        System.out.println(minOperations("card"));
    }

    //    Q1. Minimum Capacity Box©leetcode
    public static int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length;
        int minCapIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (capacity[i] >= itemSize)
                minValue = Math.min(capacity[i], minValue);
            if (capacity[i] <= minValue && capacity[i] >= itemSize)
                minCapIndex = i;
        }
        return minCapIndex;
    }

    /*-------------------------------------------------------------------*/

    //    Q2. Find the Smallest Balanced Index©leetcode
    public static int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        if (n < 2) return -1;
        for (int i = 0; i < n; i++) {
            long leftSum = leftSum(nums, i);
            long rightProduct = rightProduct(nums, i);
            if (leftSum == rightProduct) {
                return i;
            }
        }
        return -1;
    }

    // {2,8,2,2,5};
    public static int smallestBalancedIndex_better(int[] nums) {
        if (nums.length < 2) return -1;

        int n = nums.length;
        long[] preSum = prefixSum(nums);
        long[] sufProduct = suffixProduct(nums);
        for (int i = 0; i < n; i++) {
            long leftSum = 0;
            long rightProduct = 1;
            if (i != 0)
                leftSum = preSum[i - 1];
            if (i != n - 1)
                rightProduct = sufProduct[i + 1];
            if (leftSum == rightProduct)
                return i;
        }

        return -1;
    }

    // {2,8,2,2,5}; => {2, 10, 12, 14, 19}
    public static long[] prefixSum(int[] nums) {
        int n = nums.length;
        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        return preSum;
    }

    // {2,8,2,2,5}; => {320, 160, 20, 10, 5}
    public static long[] suffixProduct(int[] nums) {
        int n = nums.length;
        long[] suffProd = new long[n];
        suffProd[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffProd[i] = suffProd[i + 1] * nums[i];
        }
        return suffProd;
    }

    public static long leftSum(int[] nums, int n) {
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
        }
        return sum;
    }

    public static long rightProduct(int[] nums, int i) {
        int n = nums.length;
        long product = 1;
        for (int j = i + 1; j < n; j++) {
            product *= nums[j];
        }
        return product;
    }

    // Q3. Minimum Operations to Sort a String©leetcode
    public static int minOperations(String s) {
        int n = s.length();
        if(n < 3) return -1;
        int count = 0;
        for (int i=1; i<n; i++) {
            if (s.charAt(i-1) - 'a' > s.charAt(i) - 'a') {
                count++;
            }
        }
        return count != -1 ? count : -1;
    }

}
