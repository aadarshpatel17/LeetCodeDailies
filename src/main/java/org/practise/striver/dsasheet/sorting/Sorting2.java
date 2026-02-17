package org.practise.striver.dsasheet.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting2 {


    /*
    * MERGE SORT:
    * * TC: nlogn & SC: O(n)
    * **/

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 5, 2};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int low, int high) {
        // base case;
        if (low >= high) {
            return;
        }
        // recursion
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }
    public static void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        for(int i=low; i<=high; i++) {
            nums[i] = temp.get(i-low);
        }
    }


    /* QUICK SORT:
        TC: nlogn
    */
    public static void quickSort(int[] nums, int low, int high) {
        // base case
        if(low >= high) {
            return;
        }
        int pivot = partition(nums, low, high);
        quickSort(nums, low, pivot-1);
        quickSort(nums, pivot+1, high);
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i=low;
        int j = high;
        while(i < j) {
            while(i <= high && nums[i] <= pivot) {
                i++;
            }
            while(j >= low && nums[j] > pivot ) {
                j--;
            }
            if(i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[low] = nums[j];
        nums[j] = pivot;
        return j;
    }


}
