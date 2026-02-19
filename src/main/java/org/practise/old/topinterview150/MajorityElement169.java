package org.practise;

import java.io.*;
import java.util.Arrays;

public class MajorityElement169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

        bw.write(String.valueOf(majorityElementOptimize(nums)));

        bw.flush();
        bw.close();
    }

//    [1,1,1,2,2,2,2]
    public static int majorityElementOptimize(int[] nums) {
        int n = nums.length;
        int left = 0;
        int maxCount = 0;
        int res = 0;
        Arrays.sort(nums);
        while(left < n) {
            int count = 1;
            while((left+1 < n) && nums[left] == nums[left+1]) {
                count++; left++;
            }
            if(maxCount < count) {
                maxCount =  count;
                res = nums[left];
            }
            left++;

        }
        return res;
    }


//    brute-force
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int maxEle = 0;
        int res = 0;
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            int count = 1;
            for(int j=0; j<n; j++) {
                if(i!=j && nums[i] == nums[j])
                    count++;
            }
            if(maxEle < count) {
                maxEle = count ;
                res = nums[i];
            }
        }

        return res;
    }
}
