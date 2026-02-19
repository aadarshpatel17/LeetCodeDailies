package org.practise;

import java.io.*;
import java.util.Enumeration;

public class ContainerWithMostWater11 {
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

        bw.write(String.valueOf(maxAreaOpti(ar)));

        bw.flush();
        bw.close();
    }

//    [1,8,6,2,5,4,8,3,7]
    public static int maxAreaOpti(int[] height) {
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

//    brute force O(n^2)
    public static int maxArea(int[] height) {
        int n = height.length;
        int maxProd = 0;
        int res = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j) {
                    int h = Math.min(height[i], height[j]);
                    int l =  Math.abs(j-i);
                    maxProd = h * l;
                }
                if(res < maxProd)
                    res = maxProd;
            }
        }
        return res;
    }
}
