package org.practise.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revision_17_02_2026 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selection_sort(new int[]{5, 4, 1, 3, 2, 3})));
        System.out.println(Arrays.toString(bubble_sort(new int[]{5, 4, 1, 3, 2, 3})));
        System.out.println(Arrays.toString(insertion_sort(new int[]{5, 4, 1, 3, 2, 3})));
        int[] num1 = new int[]{5, 4, 1, 3, 2, 3};
        int[] num2 = new int[]{5, 4, 1, 3, 2, 3};
        merge_sort(num1, 0, 5);
        System.out.println(Arrays.toString(num1));
        quick_sort(num2, 0, 5);
        System.out.println(Arrays.toString(num2));
    }

    /*
        SELECTION SORT:
            - Divide the array into two parts:
                - Sorted part (left)
                - Unsorted part (right)

            - For each position i:
                - Find the minimum element in the unsorted portion
                - Swap it with the element at position i;
                - Expand the sorted portion

        - Observations:
            - Two nested loops:
                - Outer loop runs n-1 times
                - Inner loop find the minimum in remaining array
            - Total comparisons = n(n-1)/2
            - At most n-1 swaps
            - TC: o(n^2)
            - SC = O(1)
            - Not Stable
    * */
    public static int[] selection_sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // selection the min
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, i, minIndex);
            }
        }
        return nums;
    }

    /*
        - BUBBLE SORT:
            - Repeatedly compare adjacent elements
            - If they are in wrong order, swap them
            - After each pass:
                - The largest unsorted element BUBBLES to the end
            -   Shrink the unsorted portion from the right

        - Observation:
            - Two nested loops:
                - Outer loop runs n-1 times (number of passes)
                - Inner loop compares adjacent element up to (n - 1 - i)
            - After i-th pass:
                - Last i elements are already sorted
            - Can be optimized using a SWAPPED flag:
                - If no swaps in a full pass -> array is already sorted -> stop early

            - Total comparison (worst case) = n(n-1)/2
            - Swaps: Can be many (up to n(n-1)/2 in worst case)
            - TC: Worst case: O(n^2), Avg Case: O(n^2), Best case: O(n)
            - SC: O(1)
            - Stable
    */
    public static int[] bubble_sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return nums;
    }

    /*
        INSERTION SORT:
            - Divide the array into:
                Sorted Part (left)
                Unsorted Part (right)

            - Start from index 1
            - Take the current element (key)
            - Compare it with elements in the sorted portion (left side)
            - Shift larger elements one position to the right
            - Insert the key in its correct position

            - Observations:
                - Outer loop runs from 1 to n-1;
                - Inner loop shifts elements until correct position is found
                - No unnecessary swaps (only shifting)

                - TC: Best: O(n), Avg: O(n^2), Worst: O(n^2)
                - SC: O(1)
                - Stable
                - Adaptive (works very well for nearly sorted arrays)
    */
    public static int[] insertion_sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    /*
        MERGE SORT:
            - Divide the array into two halves
            - Recursively sort left half
            - Recursively sort right half
            - Merge the two sorted halves

        - Observations:
            - Uses Divide and Conquer
            - Recursion depth = log n
            - Each merge step takes O(n)
            - Total Time Complexity = O(n log n)
            - Space Complexity = O(n) (extra array used)
            - Stable
            - Not in-place (because of extra storage)
    */
    public static void merge_sort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        merge_sort(nums, left, mid);
        merge_sort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        List<Integer> list = new ArrayList<>();
        int l = left;
        int r = mid + 1;
        while(l <= mid && r <= right) {
            if(nums[l] <= nums[r]) {
                list.add(nums[l]);
                l++;
            } else {
                list.add(nums[r]);
                r++;
            }
        }
        while(l <= mid) {
            list.add(nums[l]);
            l++;
        }
        while(r <= right) {
            list.add(nums[r]);
            r++;
        }
        for(int i=left; i<=right; i++) {
            nums[i] = list.get(i-left);
        }
    }

    public static void quick_sort(int[] nums, int low, int high) {
        if(low >= high) return;

        int pivot = partition(nums, low, high);
        quick_sort(nums, low, pivot-1);
        quick_sort(nums, pivot+1, high);
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int left = low;
        int right = high;
        while(left < right) {
            while(left <= high && nums[left] <= pivot) {
                left++;
            }
            while(right >= low && nums[right] > pivot) {
                right--;
            }
            if(left < right) {
                int temp = nums[left];
                nums[left]  =nums[right];
                nums[right] = temp;
            }
        }
        nums[low] = nums[right];
        nums[right] = pivot;
        return right;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
