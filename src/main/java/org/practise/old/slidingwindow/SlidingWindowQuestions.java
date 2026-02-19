package org.practise;

import java.io.*;

public class SlidingWindowQuestions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

        String k = br.readLine();

        bw.write(String.valueOf(maxAvgSubarray(nums, Integer.parseInt(k))));

        bw.flush();
        bw.close();
    }

    public static int maxSumSubarray(int[] nums, int k) {
        int n = nums.length;
        int i = 0; int j = 0; int sum = 0; int maxSum = 0;
        while(j < n) {
            sum += nums[j];
            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[i];
                i++; j++;
            }
        }
        return maxSum;
    }

    public static double maxAvgSubarray(int[] nums, int k) {
        int n = nums.length;
        int i = 0; int j = 0; int sum = 0; double maxAvg = Integer.MIN_VALUE;
        while(j < n) {
            sum += nums[j];
            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k) {
                double avg = (double) sum / k;
                maxAvg = Math.max(avg, maxAvg);
                sum -= nums[i];
                i++; j++;
            }
        }
        return maxAvg;
    }
}
