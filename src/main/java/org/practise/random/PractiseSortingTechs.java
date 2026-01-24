package org.practise.random;

import java.util.Arrays;

public class PractiseSortingTechs {

    public static void main(String[] args) {
        int nums[] = {5, 4, 3, 2, 1};
        int nums1[] = {1, 2, 3, 4, 5};
        int nums2[] = {3, 2, 1, 5, 4};
//        bubbleSort(nums);
//        selectionSort(nums);
        insertionSort(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                j -= 1;
            }
        }
    }

    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            boolean didSwap = false;
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }
    }

}
