package org.practise;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();

        // sum of first n natural number = n * (n + 1) / 2;
        long sumOfNNaturalNumbers = n * (n + 1) / 2;

        long sumOfGivenArray = 0;
        for(int i=0; i<n-1; i++)
            sumOfGivenArray += input.nextLong();
        System.out.println(sumOfNNaturalNumbers - sumOfGivenArray);


/*
//        brute-force
        for(int i=0; i<nums.length; i++)
            nums[i] = input.nextLong();
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            if(nums[i] != i+1) {
                System.out.println(i+1);
                break;
            }
        }
 */

    }
}
