package org.practise;

import java.io.*;
import java.util.Arrays;

public class ProductArrayExceptSelf238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        int[] ar = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            ar[i] = Integer.parseInt(arr[i]);

        bw.write(Arrays.toString(productExceptSelfWithOutDivision(ar)));

        bw.flush();
        bw.close();
    }

    public static int[] productExceptSelfWithOutDivision(int[] nums) {
        int n = nums.length;
        int[] prefixLeft = new int[n];
        prefixLeft[0] = 1;
        for(int i=1; i<n; i++)
            prefixLeft[i] = prefixLeft[i-1] * nums[i-1];
        int productRight = 1;
        for(int i=n-1; i>=0; i--) {
            prefixLeft[i] = prefixLeft[i] * productRight;
            productRight *= nums[i];
        }
        return prefixLeft;
    }

    public static int[] productExceptSelfWithDivison2(int[] nums) {
        int n = nums.length;
        int totalProduct = 1;
        int zeroCount = 0;
        int[] res = new int[n];

        for(int num: nums) {
            if(num != 0)
                totalProduct *= num;
            else
                zeroCount++;
        }

        for(int i=0; i<n; i++) {
            if(zeroCount > 1) {
                res[i] = 0;
            } else if(zeroCount == 1) {
                res[i] = (nums[i] == 0) ? totalProduct: 0;
            } else {
                res[i] = totalProduct / nums[i];
            }
        }

        return res;
    }

    public static int[] productExceptSelfWithDivison(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefixMultiple = new int[n];
        prefixMultiple[0] = 1;
        for(int i=1; i<n; i++)
           prefixMultiple[i] = prefixMultiple[i-1] * nums[i];

        System.out.println(Arrays.toString(prefixMultiple));

        for(int i=0; i<n; i++)
            if(prefixMultiple[i] != 0 && nums[i] != 0)
                res[i] = prefixMultiple[n-1] / nums[i];
        return res;
    }


//    brute-force: O(n^2)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(i != j)
                    res[i] = res[i] * nums[j];
        return res;
    }
}
