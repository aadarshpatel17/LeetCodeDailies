package org.practise.striver.dsasheet.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_01 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 5};
        Array_01 array01 = new Array_01();
        // Find the Largest element in an array
        System.out.println(array01.largestElement(nums));
        System.out.println(array01.largestElement_withoutSorting(nums));

        // Find Second Smallest and Second Largest Element in an array
        System.out.println(array01.secondLargestElement(nums));
        System.out.println(array01.secondSmallestElement(nums));

        // Check if an Array is Sorted
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(array01.isSorted(list));

        // Remove duplicates from sorted array
        int[] nums1 = {0, 0, 3, 3, 5, 6};
        System.out.println(array01.removeDuplicates(nums1));

        // Left Rotate the Array by One
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array01.leftRotateArray(nums2, 2)));

        // Right Rotate the Array by One
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array01.rightRotateArray(nums3, 2)));


    }

    // Find the Largest element in an array
    public int largestElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }

    public int largestElement_withoutSorting(int[] nums) {
        int largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }
        return largest;
    }

    // Find Second Smallest and Second Largest Element in an array
    public int secondLargestElement(int[] nums) {
        int largest = nums[0];
        int secondLargest = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            }
            if (nums[i] < largest && nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }

    public int secondSmallestElement(int[] nums) {
        int smallest = nums[0];
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < smallest) {
                secondSmallest = smallest;
                smallest = nums[i];
            }
            if (nums[i] > smallest && nums[i] < secondSmallest) {
                secondSmallest = nums[i];
            }
        }
        return secondSmallest;
    }

    // Check if an Array is Sorted
    public boolean isSorted(ArrayList<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                return false;
            }
        }
        return true;
    }

    // Remove duplicates from sorted array
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    // Left Rotate the Array by One
    public int[] leftRotateArray(int[] nums, int k) {
        int n = nums.length;
        rotate(nums, 0, k - 1);
        rotate(nums, k, n - 1);
        rotate(nums, 0, n - 1);
        return nums;
    }

    // Right Rotate the Array by One
    public int[] rightRotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotate(nums, 0, k);
        rotate(nums, k + 1, n - 1);
        rotate(nums, 0, n - 1);
        return nums;
    }

    public void rotate(int[] nums, int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    //    Union of two sorted arrays
    public List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        // List to store union elements
        List<Integer> Union = new ArrayList<>();

        // Initialize pointers
        int i = 0, j = 0;

        // Iterate while both arrays have elements
        while (i < n && j < m) {
            // If element in arr1 is smaller
            if (arr1[i] < arr2[j]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;  // Move pointer in arr1
            }
            // If element in arr2 is smaller
            else if (arr2[j] < arr1[i]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;  // Move pointer in arr2
            } else {
                // Elements are equal, add once if not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
                j++;  // Move both pointers
            }
        }

        // Append remaining elements from arr1
        while (i < n) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }

        // Append remaining elements from arr2
        while (j < m) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }

        // Return the union list
        return Union;
    }


}
