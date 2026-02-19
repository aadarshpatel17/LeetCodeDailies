package org.practise;

import java.io.*;
import java.util.Arrays;

public class RemoveElement27 {
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

        bw.write(String.valueOf(removeElement(nums, value)));

        bw.flush();
        bw.close();
    }

//    same tc however less code
    public static int removeElement2(int[] nums, int value) {
        int n = nums.length;
        int i=0; int j=0; int k=0;
        while(j<n && i<n) {
            if(nums[i] != value) {
                nums[j++] = nums[i++];
                    k++;
            } else i++;
        }
        return k;
    }

    //    brute-force
    public static int removeElement(int[] nums, int value) {
        int n = nums.length;
        int left = 0; int right = n - 1;
        while(left < right) {
            while(nums[right] == value) {
                if(right < 1)
                    break;
                right--;
            }
            if(nums[left] == value && left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; right--;
            } else
                left++;
        }
        int len = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == value)
                break;
            else
                len++;
        }
        return len;
    }
}
