package org.practise;

import java.io.*;
import java.util.Arrays;

public class TwoSumIISorted167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

        String target = br.readLine();

        bw.write(Arrays.toString(twoSum(nums, Integer.parseInt(target))));

        bw.flush();
        bw.close();
    }

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target)
                return new int[]{left+1, right+1};
            else if(sum < target)
                left++;
            else right--;
        }
        return new int[]{-1};
    }
}
