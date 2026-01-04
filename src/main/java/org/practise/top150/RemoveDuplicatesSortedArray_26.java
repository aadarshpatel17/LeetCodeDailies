package org.practise.top150;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesSortedArray_26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input: array
        String[] arrStr = sc.nextLine().replace("[","").replace("]","").split(",");
        int[] nums = new int[arrStr.length];
        for(int i=0; i<arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }

        int k = removeDuplicates(nums);
        System.out.println(k);
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j=0;
        for(int i=1; i<n; i++) {
            if(nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
}
