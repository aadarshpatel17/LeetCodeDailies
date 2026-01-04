package org.practise.top150;

import java.util.Arrays;
import java.util.Scanner;

public class ProductArrayExceptSelf_238 {

    public static void main(String[] args) {
        // input: array
        Scanner sc = new Scanner(System.in);
        String[] arrStr = sc.nextLine().replace("[","").replace("]","").split(",");
        int[] nums = new int[arrStr.length];
        for(int i=0; i< arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixLeft = new int[n];
        prefixLeft[0] = 1;
        for(int i=1; i<n; i++)
            prefixLeft[i] = prefixLeft[i-1] * nums[i-1];
        int prefixRight = 1;
        for(int i=n-1; i>=0; i--) {
            prefixLeft[i] = prefixLeft[i] * prefixRight;
            prefixRight *= nums[i];
        }
        return prefixLeft;
    }

}
