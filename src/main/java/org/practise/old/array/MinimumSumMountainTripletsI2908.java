package org.practise;

import java.io.*;
import java.util.Arrays;

public class MinimumSumMountainTripletsI2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        int[] ar = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            ar[i] = Integer.parseInt(arr[i]);

        bw.write(String.valueOf(minimumSum(ar)));

        bw.flush();
        bw.close();
    }

    public static int minimumSum(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++) {
            int currMin = 0;
            int j = i+1; int k = nums.length-1;
            while (j < k) {
                if ((i < j) && (j < k)) {
                    if((nums[i] < nums[j]) && (nums[k] < nums[j])) {
                        currMin = nums[i] + nums[j] + nums[k];
                    } else if(nums[i] > nums[j]) {
                        j++;
                        continue;
                    } else if(nums[k] > nums[j]) {
                        k--;
                        continue;
                    }
                }
                j++;
                k--;
                if(currMin < minSum)
                    minSum = currMin;
            }
        }

        return -1;
    }
}
