package org.practise.striver.dsasheet.arrays.mid;

import java.util.HashMap;
import java.util.Map;

public class LC_01 {

    //    1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int crtTarget = target - nums[i];
            if(map.containsKey(crtTarget)) {
                return new int[]{i, map.get(crtTarget)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1};
    }

}
