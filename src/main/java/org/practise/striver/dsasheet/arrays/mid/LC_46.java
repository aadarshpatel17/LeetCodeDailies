package org.practise.striver.dsasheet.arrays.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_46 {

    //    46. Permutations
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        // space
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[n];

        // mark all element unused at start
        Arrays.fill(used, false);

        backtrack(current, used, nums, result);

        return result;
    }

    public void backtrack(List<Integer> current, boolean[] used, int[] nums, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // check if the element is already used
            if(used[i] == true) {
                continue;
            }

            // add the element in current element list
            // mark as used
            current.add(nums[i]);
            used[i] = true;

            // explore
            backtrack(current, used, nums, result);

            // backtrack
            // mark element unused
            current.remove(current.size()-1);
            used[i] = false;
        }
    }

}
