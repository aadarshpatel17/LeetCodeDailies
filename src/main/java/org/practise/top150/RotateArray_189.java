package org.practise.top150;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray_189 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // first input: array
        String[] arrStr = sc.nextLine().replace("[","").replace("]","").split(",");
        int[] nums = new int[arrStr.length];
        for(int i=0; i<arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        // second input: int k
        int k = sc.nextInt();
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);

        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public static void rotate_BF(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<k; i++) {
            int lastIndexValue = nums[n-1];
                for(int j=n-1; j>0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = lastIndexValue;
        }
        System.out.println(Arrays.toString(nums));
    }

}
