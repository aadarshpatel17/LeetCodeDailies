package org.practise.revision._2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Revision_21_dec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input first array
        String[] arr1Str = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int[] nums1 = new int[arr1Str.length];
        for (int i = 0; i < arr1Str.length; i++) {
            nums1[i] = Integer.parseInt(arr1Str[i].trim());
        }

        // Input m
//        int m = sc.nextInt();
//        sc.nextLine();
//
//        // Input second array
//        String[] arr2Str = sc.nextLine().replace("[", "").replace("]", "").split(",");
//        int[] nums2 = new int[arr2Str.length];
//        for (int i = 0; i < arr2Str.length; i++) {
//            nums2[i] = Integer.parseInt(arr2Str[i].trim());
//        }
//
//        // Input n
//        int n = sc.nextInt();

        System.out.println(Arrays.toString(productExceptSelf2(nums1)));
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for(int i=0; i<=m-n; i++) {
            String subString = haystack.substring(i,i+n);
            if(needle.equals(subString))
                return i;
        }
        return -1;
    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String prefix = strs[0];
        for(int i=0; i<n; i++) {
            while(!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
            if(prefix.isEmpty()) {
                return "";
            }
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

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }

        return sum;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int maxProduct = 1;
        for(int i=0; i<n; i++) {
            maxProduct *= nums[i];
        }
        for(int i=0; i<n; i++) {
            result[i] = maxProduct/nums[i];
        }
        return result;
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

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=1; i<n; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public static int majorityElement2(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if(freq.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int start,int end) {
        while(start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = 0;
        int count = 0;

        for(int i=0; i<n; i++) {
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

    public static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int j = 2;
        for(int i=2; i<n; i++) {
            if(nums[i] != nums[i-2]) {
                nums[j++] = nums[i];
            }
        }
        return j+1;
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 1;
        for(int i=1; i<n; i++) {
            if(nums[i] != nums[i-1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m,j=0; i<m+n; i++,j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

}
