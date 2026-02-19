package org.practise;

import java.io.*;
import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        int[] ar = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            ar[i] = Integer.parseInt(arr[i]);
        }

        bw.write(String.valueOf(removeDuplicates(ar)));

        bw.flush();
        bw.close();
    }

    public static int removeDuplicates(int[] nums) {
        int uniqueElementIndex = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[uniqueElementIndex]) {
                uniqueElementIndex++;
                nums[uniqueElementIndex] = nums[i];
            }
        }
        return uniqueElementIndex + 1;
    }
}
