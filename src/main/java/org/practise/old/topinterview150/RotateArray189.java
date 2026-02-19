package org.practise;

import java.io.*;
import java.util.Arrays;

public class RotateArray189 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

        int value = Integer.parseInt(br.readLine().trim());

        rotate(nums, value);

        bw.flush();
        bw.close();
    }

//    it's rotateRight problem so we do optimized version only
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(n > 1) {
            reverse(nums, 0, n-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, n-1);
        }
    }

    public static int[] reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
        return nums;
    }
}
