package org.practise;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveDuplicatesSortedArrayII80 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

//        int value = Integer.parseInt(br.readLine().trim());

        bw.write(String.valueOf(removeDuplicates2(nums)));

        bw.flush();
        bw.close();
    }

    //    optimized
    public static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return n;
        int write = 2;
        for(int i=2; i<n; i++) {
            if(nums[i] != nums[write-2]) {
                nums[write] = nums[i];
                write++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return write;
    }

    public static int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return n;
        int write = 0;
        for(int i=0; i<n; i++) {
            if(write < 2 || nums[i] != nums[write-2]) {
                nums[write] = nums[i];
                write++;
            }
        }
        return write;
    }

    //    brute-force
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int k = n-1;
        for(int i=0; i<n && i<=k; i++) {
            int count = 0;
            for(int j=0; j<n && j<=k; j++) {
                if(i!=j && (nums[i] == nums[j])) {
                    if(count == 1) {
                        int t = nums[j];
                        nums[j] = nums[k];
                        nums[k] = t;
                        k--;
                        break;
                    }
                    count++;
                }
            }
            list.add(nums[i]);
        }
        Collections.sort(list);
        int j= 0;
        for(int i: list)
            nums[j++] = i;
        return list.size();
    }
}
