package org.practise.dsa_training;

import java.util.Arrays;

public class Day_4_Practise {
//    283. Move Zeroes
    public void moveZeroes(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            if(nums[left] == 0) {
                // swap left & right
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else {
                left++;
            }
        }
    }

    public void moveZeroes_withoutBreakingOrder(int[] nums) {
        int left = 0;
        for(int right=0; right<nums.length; right++) {
            if(nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        while(left < nums.length) {
            nums[left++] = 0;
        }
    }

//    27. Remove Element
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] != val) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }

//    680. Valid Palindrome II
    public boolean validPalindromeII(String s) {
        int left=0, right=s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m+n-1, left = m-1, right = n-1;
        while(right >= 0) {
            if(left >= 0 && nums1[left] > nums2[right]) {
                nums1[pos--] = nums1[left--];
            } else {
                nums1[pos--] = nums2[right--];
            }
        }
    }

    // 16. 3Sum Closest
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0, maxDiff = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            int left = i+1, right = n - 1;
            while(left < right) {
                int crtSum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(crtSum - target);
                if(diff < maxDiff) {
                    maxDiff = diff;
                    ans = crtSum;
                }
                if(crtSum < target) {
                    left++;
                } else if(crtSum > target) {
                    right--;
                } else {
                    return crtSum;
                }
            }
        }
        return ans;
    }

    // 42. Trapping Rain Water
    public int trap(int[] height) {
        int water = 0;
        int left = 0, right = height.length-1;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        while(left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left] < height[right]) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

}
