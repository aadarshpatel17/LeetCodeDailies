package org.practise.leetcode_dailies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_3507 {

    //    3507. Minimum Pair Removal to Sort Array I
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int operations = 0;

        while(!isSorted(list)) {
            int index = minPairSum(list);
            int merged = list.get(index) + list.get(index + 1);
            list.set(index, merged);
            list.remove(index + 1);
            operations += 1;
        }


        return operations;
    }

    private boolean isSorted(List<Integer> nums) {
        int n = nums.size();
        for(int i=0; i<n-1; i++) {
            if(nums.get(i) > nums.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private int minPairSum(List<Integer> nums) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<n-1; i++) {
            int sum = nums.get(i) + nums.get(i+1);
            if(sum < minSum) {
                minSum = sum;
                index = i;
            }
        }
        return index;
    }

}
