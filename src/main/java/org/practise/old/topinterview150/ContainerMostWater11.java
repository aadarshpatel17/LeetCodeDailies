package org.practise;

import java.io.*;
import java.util.Arrays;

public class ContainerMostWater11 {
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

        bw.write(String.valueOf(maxArea(nums)));

        bw.flush();
        bw.close();
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0; int right = n - 1;
        int maxProd = 0;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            int l = Math.abs(right - left);
            int prod = h * l;
            if(maxProd < prod)
                maxProd = prod;
            if(height[left] < height[right])
                left++;
            else right--;
        }
        return maxProd;
    }
}
