package org.practise.dsa_training.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day3_revision {

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
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left=i+1, right=n-1;
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
                    left++;
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, mid = 0, right = n-1;
        while(mid <= right) {
            if(nums[mid] == 0) {
                // swap
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                // swap mid and right
                int temp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = temp;
                right--;
            }
        }
    }

    // sliding window question
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0, sum = 0;
        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for(int right=k; right<nums.length; right++) {
            sum += nums[right];
            sum -= nums[right - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum/k;
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        // tMap with freq
        for(int i=0; i<t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int matched = 0, required = need.size();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right<s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                matched++;
            }
            // shrink condition
            while(matched == required) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char cl = s.charAt(left);
                window.put(cl, window.get(cl) - 1);
                if(need.containsKey(cl) && window.get(cl).intValue() < need.get(cl).intValue()) {
                    matched--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


}
