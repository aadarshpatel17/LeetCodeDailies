package org.practise.revision;

import java.util.Arrays;
import java.util.HashMap;

public class Revision_20_dec {

    // Merge Sorted Array
    /* Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
            Output: [1,2,2,3,5,6]
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m, j=0; i<m+n; i++,j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }


    //  Remove Element
    /*
        Input: nums = [3,2,2,3], val = 3
        Output: 2, nums = [2,2,_,_]
    * */
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

    // Remove Duplicates from Sorted Array
    /*
    *   Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
    * **/
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j=0;
        for(int i=1; i<n; i++) {
            if(nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

    // Majority Element
    /*
        Input: nums = [3,2,3]
        Output: 3
    */
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for(int num: nums) {
            if(count == 0) {
                candidate = num;
            }
            if(candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public int majorityElementHashMap(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if(freq.get(num) > n/2) {
                return num;
            }
        }
        return -1;
    }

}
