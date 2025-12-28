package org.practise.top150.arraystring;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSumIIInputArraySorted_167 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input: array
        String[] arrStr = sc.nextLine().replace("[","").replace("]","").split(",");
        int[] nums = new int[arrStr.length];
        for(int i=0; i< arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i].trim());
        }
        // input: int
        int target = sc.nextInt();
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target)
                return new int[]{left + 1, right + 1};
            else if(sum < target)
                left++;
            else
                right--;
        }
        return new int[]{-1};
    }
}
