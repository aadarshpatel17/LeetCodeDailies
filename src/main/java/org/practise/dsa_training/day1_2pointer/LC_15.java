package org.practise.dsa_training.day1_2pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int n =  nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            // duplicate
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = n - 1;
            int target = -nums[i];
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left< right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

}
