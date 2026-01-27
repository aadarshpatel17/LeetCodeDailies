package org.practise.striver.dsasheet.arrays.mid;

import java.util.HashMap;
import java.util.Map;

public class LC_169 {

    //    169. Majority Element
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    public int majorityElement_optimize(int[] nums) {
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

}
