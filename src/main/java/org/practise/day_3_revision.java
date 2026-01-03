package org.practise;

import java.util.ArrayList;
import java.util.List;

public class day_3_revision {

    public void reverseString(char[] s) {
        int left = 0, right = s.length -1;
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome_withoutRegex(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if(!Character.isLetterOrDigit(lc)) {
                left++;
            } else if(!Character.isLetterOrDigit(rc)) {
                right--;
            } else {
                if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public int removeDuplicates(int[] nums) {
        int left = 0;
        for(int right = 0; right< nums.length; right++) {
            if(nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n-1;
        int pos = n-1;
        while(left <= right) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[pos--] = nums[right] * nums[right];
                right--;
            } else {
                res[pos--] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            int l = right - left;
            int prod = h * l;
            max = Math.max(max, prod);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[]{left+1, right+1};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        return result;
    }

}
