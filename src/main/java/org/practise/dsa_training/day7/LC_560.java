package org.practise.dsa_training.day7;

import java.util.HashMap;
import java.util.Map;

public class LC_560 {

    // brute force : Wrong because we should not use 2 pointer / sliding window with negative numbers
    public int subarraySum_bruteForce(int[] nums, int k) {
        int sum = 0;
        int count = 0, left = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                count++;
            } else {
                while(sum > k) {
                    sum -= nums[left++];
                    if(sum == k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int subarraySumOptimial(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // base case
        for(int num: nums) {
            sum += num;
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
