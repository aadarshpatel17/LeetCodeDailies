package org.practise.dsa_training.day7;

import java.util.HashMap;
import java.util.Map;

public class LC_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right<nums.length; right++) {
            int currTarget = target - nums[right];
            if(map.containsKey(currTarget)) {
                return new int[] {right, map.get(currTarget)};
            }
            map.put(nums[right], right);
        }
        return new int[] {-1};
    }

}
