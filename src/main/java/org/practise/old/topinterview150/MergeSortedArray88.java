package org.practise.old.topinterview150;

import java.io.*;
import java.util.Arrays;

public class MergeSortedArray88 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

        int m = Integer.parseInt(br.readLine().trim());

        String input2 = br.readLine();
        input2 = input2.trim().replaceAll("^\\[|\\]$", "");
        String[] parts2 = input2.split(",\\s*");
        int[] nums2 = new int[parts2.length];
        for (int i = 0; i < parts2.length; i++)
            nums2[i] = Integer.parseInt(parts2[i]);

        int n = Integer.parseInt(br.readLine().trim());


        merge(nums, m, nums2, n);

        bw.flush();
        bw.close();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m, j=0; i<m+n; i++, j++)
            nums1[i] = nums2[j];
        Arrays.sort(nums1);
    }
}
