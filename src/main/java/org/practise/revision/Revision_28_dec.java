package org.practise.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Revision_28_dec {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m,j=0; i<m+n; i++,j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j=0;
        for(int i=0; i<n; i++) {
           if(nums[i] != val) {
               nums[j++] = nums[i];
           }
        }
        return j;
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j=1;
        for(int i=1; i<n; i++) {
            if(nums[i] != nums[i-1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeDuplicatesII(int[] nums) {
        int n = nums.length;
        int j = 2;
        for(int i=2; i<n; i++) {
            if(nums[i] != nums[j-2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = -1;
        int count = 0;
        for(int i=0;i<n;i++) {
            if(count == 0) {
                candidate = nums[i];
            }
            if(candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public int majorityElementII(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if(freq.get(num) > n/2) {
                return num;
            }
        }
        return -1;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<n; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public int[] productExceptSelfWithoutZeroes(int[] nums) {
        int n = nums.length;
        int[] productArr = new int[n];
        int product = 1;
        for(int i=0; i<n; i++) {
            product *= nums[i];
        }
        for(int i=0; i<n; i++) {
            productArr[i] = product/nums[i];
        }
        return productArr;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        int prefixRight = 1;
        for(int i=n-1; i>=0; i--) {
            prefix[i] = prefix[i] * prefixRight;
            prefixRight *= nums[i];
        }
        return prefix;
    }

    public int romanToInt(String s) {
        int sum = 0;
        String str1 = s.replace("IV","IIII");
        String str2 = str1.replace("IX","VIIII");
        String str3 = str2.replace("XL","XXXX");
        String str4 = str3.replace("XC","LXXXX");
        String str5 = str4.replace("CD","CCCC");
        String str = str5.replace("CM","DCCCC");

        for(char ch: str.toCharArray()) {
            switch(ch) {
                case 'I': sum += 1; break;
                case 'V': sum += 5; break;
                case 'X': sum += 10; break;
                case 'L': sum += 50; break;
                case 'C': sum += 100; break;
                case 'D': sum += 500; break;
                case 'M': sum += 1000; break;
            }
        }
        return sum;
    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String lcp = strs[0];
        for(int i=0; i<n; i++) {
            while(!strs[i].startsWith(lcp)) {
                lcp = lcp.substring(0, lcp.length()-1);
            }
            if(lcp.isEmpty()) {
                return "";
            }
        }
        return lcp;
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for(int i=0; i<=m-n; i++) {
            if(needle.equals(haystack.substring(i, i+n))) {
                return i;
            }
        }
        return -1;
    }

    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        int left = 0;
        int right = str.length()-1;
        while(left < right) {
            if(!(str.charAt(left) == str.charAt(right))) {
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
        int left = 0, right = 0, count = 0;
        while(left < s.length() && right < t.length()) {
            if(s.charAt(left) == t.charAt(right)) {
                left++; right++; count++;
            } else {
                right++;
            }
        }
        return count == s.length();
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0; 
        int right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[] {left+1, right+1};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1};
    }

    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        int left = 0, right = n - 1;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            int l = right - left;
            int product = h * l;
            max = Math.max(product, max);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++) {
            // skip duplicate for i
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = n - 1;
            int target = -nums[i];
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // skip duplicates
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
