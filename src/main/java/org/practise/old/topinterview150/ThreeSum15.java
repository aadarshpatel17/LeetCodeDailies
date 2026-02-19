package org.practise;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

//        String target = br.readLine();

        bw.write(String.valueOf(threeSum(nums)));

        bw.flush();
        bw.close();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++) {
            //skip duplicates for i
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int target = -nums[i];
            int left = i + 1; int right = n - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    skip duplicates for left and right
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if(sum < target)
                    left++;
                else right--;
            }
        }
        return result;
    }
}
