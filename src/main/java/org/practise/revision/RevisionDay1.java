package org.practise.revision;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;

public class RevisionDay1 {

    // top 150 interview questions

    public static void main(String[] args) {
        RevisionDay1 refer = new RevisionDay1();

        int[] n1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] n2 = {2, 5, 6};
        int n = 3;

        int[] nums = {2,1,0,1,4};

//        refer.rotateLeft(nums, 3);
        System.out.println(refer.canJumpII(nums));
    }

    // 88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        // BF
        int j = m;
        for(int i=0; i<n; i++) {
            nums1[j++] = nums2[i];
        }
        Arrays.sort(nums1);
        */

        /*
        // wrong approach
        int left = 0, right = 0;
        int[] res = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if(nums1[left] == 0) {
                res[i] = nums2[right];
                left++;
                right++;
            } else if(nums2[right] == 0) {
                res[i] = nums1[left];
                left++;
                right++;
            } else {
                res[i] = nums1[left] < nums2[right] ? nums1[left++] : nums2[right++];
            }
        }

        for(int i=0; i<m+n; i++) {
            nums1[i] = res[i];
        }
        */

        /*
        // optimized
        insert larger element from the end of nums1 array
        by comparing nums1 and nums2 from the end by using 2 pointers
         */
        int pos = m + n - 1;
        int left = m - 1;
        int right = n - 1;
        while (right >= 0) {
            if (left >= 0 && nums1[left] > nums2[right]) {
                nums1[pos--] = nums1[left--];
            } else {
                nums1[pos--] = nums2[right--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }

    // 27. Remove Element
    public int removeElement(int[] nums, int val) {
        int write = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                write++;
                nums[write] = nums[i];
            }
        }
        return write;
    }

    // 26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int write = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[write] != nums[i]) {
                write++;
                nums[write] = nums[i];
            }
        }
        System.out.println(write + 1);
        return write + 1;
    }

    // 80. Remove Duplicates from Sorted Array II
    public int removeDuplicatesII(int[] nums) {
        int write = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[write - 2]) {
                nums[write++] = nums[i];
            }
        }
        System.out.println(write);
        return write;
    }

    // 169. Majority Element
    public int majorityElement_apI(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }

    public int majorityElement_apII(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    // 189. Rotate Array
    public void rotateRight(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, k - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = -1;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            max = Math.max(max, prices[i] - minPrice);
        }
        return max;
    }

    // 122. Best Time to Buy and Sell Stock II
    public int maxProfitII(int[] prices) {
        int n = prices.length;
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            int profit = prices[i] - minPrice;
            if(profit > 0) {
                max += profit;
                minPrice = prices[i];
            }
        }
        return max;
    }

    // 55. Jump Game
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int furthest = 0;
        for(int i=0; i<n; i++) {
            if(i > furthest) return false;
            furthest = Math.max(furthest, i + nums[i]);
        }
        return furthest >= n - 1;
    }

    // 45. Jump Game II
    public int canJumpII(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int furthest = 0;
        int jump = 0;
        int currentEnd = 0;
        for(int i=0; i<n-1; i++) {
            if(i > furthest) return -1;
            furthest = Math.max(furthest, i + nums[i]);
            if(i == currentEnd) {
                jump++;
                currentEnd = furthest;
            }
        }
        return jump;
    }
}
