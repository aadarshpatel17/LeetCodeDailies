package org.practise.leetcode_dailies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_1200 {

    //    1200. Minimum Absolute Difference
    public static void main(String[] args) {
        int[] nums = {40,11,26,27,-20};
        System.out.println(Collections.singletonList(minimumAbsDifference(nums)));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // sort
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        // find the minDiff in the sorted array;
        for(int i=0; i<nums.length-1; i++) {
            int diff = Math.abs(nums[i] - nums[i+1]);
            minDiff = Math.min(minDiff, diff);
        }
        // add only the minDiff value in the result list;
        for(int i=0; i<nums.length-1; i++) {
            int diff = Math.abs(nums[i] - nums[i+1]);
            if(diff == minDiff) {
                result.add(new ArrayList<>(List.of(nums[i], nums[i+1])));
            } else {

            }
        }
        return result;
    }
    public static List<List<Integer>> minimumAbsDifference_SlightlyOptmize(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // sort
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        // find the minDiff in the sorted array;
        for(int i=0; i<nums.length-1; i++) {
            int diff = Math.abs(nums[i] - nums[i+1]);
            if(diff == minDiff) {
                result.add(new ArrayList<>(List.of(nums[i], nums[i+1])));
                continue;
            }
            if(diff < minDiff) {
                result.clear();
                result.add(new ArrayList<>(List.of(nums[i], nums[i+1])));
                minDiff = diff;
            }
        }
        return result;
    }



}
