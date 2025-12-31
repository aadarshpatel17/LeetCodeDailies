package org.practise.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if(k >= n) {
            k = n-1;
        }
        for(int i=0; i<n-k; i++) {
            HashMap<Integer, Integer> storedValues = new HashMap<>();
            for(int j=i; j<=i+k; j++) {
                if(storedValues.containsKey(nums[j])) {
                    return true;
                }
                storedValues.put(nums[j], j);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate_optimized(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> window = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if(window.size() > k) {
                window.remove(nums[i-k]);
            }
        }
        return false;
    }

}
