package org.practise;

import java.io.*;
import java.util.Arrays;

public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);


        bw.write(String.valueOf(minSubArrayLen(Integer.parseInt(target), nums)));

        bw.flush();
        bw.close();
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0; int right = 1;
        int n = nums.length;
        int minSub = Integer.MAX_VALUE;
        int temp = minSub;

        while(left < n && right < n) {
            int sum = nums[left]; int len = 2;
            while(right < n && left < n) {
                sum += nums[right];
                if(sum == target) {
                    if(len < minSub)
                        minSub = len;
                    len--;
                    sum = sum - nums[left] - nums[right];
                    left++;
                }
                else if(sum < target) {
                    len++;
                    right++;
                } else {
                    len--;
                    sum = sum - nums[left] - nums[right];
                    left++;
                }
            }
        }
        return minSub == temp ? 0: minSub;
    }
}
