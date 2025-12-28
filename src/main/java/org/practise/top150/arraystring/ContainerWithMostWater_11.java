package org.practise.top150.arraystring;

import java.util.Scanner;

public class ContainerWithMostWater_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input: array
        String[] arrStr = sc.nextLine().replace("[","").replace("]","").split(",");
        int[] nums = new int[arrStr.length];
        for(int i=0; i< arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        System.out.println(maxArea(nums));
    }

    public static int maxArea(int[] height) {
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

    
}
