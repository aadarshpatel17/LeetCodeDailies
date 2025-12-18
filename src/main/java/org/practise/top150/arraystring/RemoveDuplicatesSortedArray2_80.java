package org.practise.top150.arraystring;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesSortedArray2_80 {
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
        int j=2;
        for(int i=2; i<n; i++) {
            if(nums[i] != nums[j-2]) {
                nums[j++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
}
