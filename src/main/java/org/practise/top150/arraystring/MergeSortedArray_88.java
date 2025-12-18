package org.practise.top150.arraystring;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first array
        String[] arr1Str = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int[] nums1 = new int[arr1Str.length];
        for (int i = 0; i < arr1Str.length; i++) {
            nums1[i] = Integer.parseInt(arr1Str[i].trim());
        }

        // Input m
        int m = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input second array
        String[] arr2Str = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int[] nums2 = new int[arr2Str.length];
        for (int i = 0; i < arr2Str.length; i++) {
            nums2[i] = Integer.parseInt(arr2Str[i].trim());
        }

        // Input n
        int n = sc.nextInt();

        bruteForce(nums1, m, nums2, n);
//        optimized(num1, m, num2, n);

    }

    public static void bruteForce(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m, j=0; i<m+n; i++,j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
        System.out.println(nums1);
    }
}
