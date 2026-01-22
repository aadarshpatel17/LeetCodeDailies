package org.practise.striver.dsasheet.recursion;

import java.util.Arrays;

public class _04_ReverseArray {

    //    Reverse a given Array
    public static void main(String[] args) {
        _04_ReverseArray a02BasicRecursion = new _04_ReverseArray();

/*        int n = 5;
        int[] nums = {5,4,3,2,1};

        // brute force
        System.out.println(Arrays.toString(a02BasicRecursion.reverse_BC(n, nums)));
        // optimized
        a02BasicRecursion.reverse_optimized(n, nums);
        System.out.println(Arrays.toString(nums));
        // built-in function;
        int[] nums1 = {5,4,3,2,1};
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
        // using recursion;
        int[] nums2 = {5,4,3,2,1};
        a02BasicRecursion.reverseUsingRecursion(0, n-1, nums2);
        System.out.println(Arrays.toString(nums1));
        // using recursion2;
        int[] nums3 = {5,4,3,2,1};
        a02BasicRecursion.reverseUsingRecursion2(0, n, nums3);
        System.out.println(Arrays.toString(nums1));*/


        // palindrome using recursion
        String s1 = "naman";
        String s2 = "aman";
        System.out.println(palindromeUsingRecursion(s1, 0, s1.length()));
        System.out.println(palindromeUsingRecursion(s2, 0, s2.length()));
    }

    public static boolean palindromeUsingRecursion(String s, int i, int n) {
        if (i >= n / 2) return true;
        // check
        if (s.charAt(i) != s.charAt(n - 1 - i))
            return false;
        return palindromeUsingRecursion(s, i + 1, n);
    }

    public void reverseUsingRecursion2(int i, int n, int[] nums) {
        if (i >= n / 2) return;
        // swap
        int temp = nums[i];
        nums[i] = nums[n - 1 - i];
        nums[n - 1 - i] = temp;
        reverseUsingRecursion(i + 1, n - 1 - i - 1, nums);
    }

    public void reverseUsingRecursion(int left, int right, int[] nums) {
        if (left >= right) return;
        // swap
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        reverseUsingRecursion(left + 1, right - 1, nums);
    }

    public int[] reverse_BC(int n, int[] nums) {
        int[] reversedArray = new int[n];
        for (int i = 0; i < n; i++) {
            reversedArray[i] = nums[n - 1 - i];
        }
        return reversedArray;
    }

    public void reverse_optimized(int n, int[] nums) {
        int left = 0, right = n - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
