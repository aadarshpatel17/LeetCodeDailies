package org.practise.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revision_30_dec {

    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        int left = 0;
        int right = str.length()-1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }
        if(t.isEmpty()) {
            return false;
        }

        int m = s.length();
        int n = t.length();
        int left = 0;
        int right = 0;
        int count = 0;

        while(left < m && right < n) {
            if(s.charAt(left) == t.charAt(right)) {
                count++;
                left++;
                right++;
            } else {
                right++;
            }
        }

        return count == m;
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n -1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[] {left+1, right+1};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1};
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int left = 0, right = n - 1;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            int l = right - left;
            int crtMax = h * l;
            max =  Math.max(max, crtMax);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = n - 1;
            int target = -nums[i];
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++; right--;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

}
