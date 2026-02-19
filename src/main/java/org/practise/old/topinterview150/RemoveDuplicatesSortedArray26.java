package org.practise;

import java.io.*;
import java.util.*;

public class RemoveDuplicatesSortedArray26 {
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

        bw.write(String.valueOf(removeDuplicates1(nums)));

        bw.flush();
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int k = 1;
        for(int i=1; i<n; i++)
            if(nums[i-1] != nums[i])
                nums[k++] = nums[i];
        return k;
    }

//    [0,0,1,1,2,3,4]
    public static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n: nums) list.add(n);
        HashSet<Integer> set = new HashSet<>(list);
        int[] num = new int[set.size()];
        int i = 0;
        for (int n : set)
            num[i++] = n;
        Arrays.sort(num);
        i = 0;
        for(int n: num)
            nums[i++] = n;
        return set.size();
    }
}
