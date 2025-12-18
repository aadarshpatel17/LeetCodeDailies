package org.practise.top150.arraystring;

import java.util.Scanner;

public class RemoveElement_27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input: array
        String[] arrStr = sc.nextLine().replace("[","").replace("]","").split(",");
        int[] nums = new int[arrStr.length];
        for(int i=0; i<arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        int val = sc.nextInt();

        System.out.println(removeElement(nums, val));

    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j=0;
        for(int i=0; i<n; i++) {
            if(nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
