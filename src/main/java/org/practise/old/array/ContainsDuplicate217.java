package org.practise;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class ContainsDuplicate217 {
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

        bw.write(String.valueOf(containsDuplicate(ar)));

        bw.flush();
        bw.close();
    }

    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] == nums[i])
                return true;
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> storedValues = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(storedValues.containsKey(nums[i]))
                return true;
            storedValues.put(nums[i], i);
        }
        return false;
    }
}
