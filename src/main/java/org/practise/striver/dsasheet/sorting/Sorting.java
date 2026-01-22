package org.practise.striver.dsasheet.sorting;

import java.util.Arrays;

public class Sorting {

    // Selection Sort
    // Bubble Sort
    // Insertion Sort

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 5, 2};
        int n = 5;
//        selectionSort(nums);
//        bubbleSort(nums);
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    // select the min value, swap it with front element
    /*
        TC:
            Avg Case: O(n^2)
            Worst Case: O(n^2)
            Best Case: O(n^2)
    * */
    public static void selectionSort(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume current index holds the minimum

            // Find the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {
                // get the min element index
                if (nums[j] < nums[minIndex]) {
                    minIndex = j; // Update minIndex if smaller is found
                }
            }
            // Swap the found minimum element with the first element of unsorted part
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    // bubble sort: bubble out the highest value to the end
    // meaning: compare 2 element and swap if the left element is bigger
    /*
        TC:
            Worst Case: O(n^2)
            Avg Case: O(n^2)
            Best Case: O(n) after optimization
    */
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {   //Use two nested loops to iterate over the array
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];  //Swap arr[j+1] with arr[i];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortOptimized(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {   //Use two nested loops to iterate over the array
            boolean didSwap = false;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];  //Swap arr[j+1] with arr[i];
                    nums[j] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }
    }


    /*
        Insertion Sort:
            -
        TC:
            Worst Case: O(n^2)
            Avg Case: O(n^2)
            Best Case: O(n)
    */
    public static void insertionSort(int[] nums) {
        int n = nums.length; // Size of the array

        // For every element in the array
        for (int i = 1; i < n; i++) {
            int key = nums[i]; // Current element as key
            int j = i - 1;

            // Shift elements that are greater than key by one position
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key; // Insert key at correct position
        }

    }

}
