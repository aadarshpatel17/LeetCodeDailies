package org.practise.leetcode_dailies;

import java.util.ArrayList;

public class LC_1390 {

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += sumOfDivisors(nums[i]);
        }
        return sum;
    }

    public int sumOfDivisors(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        for(int i=1; i<=n; i++) {
            if(n % i == 0) {
                result.add(i);
            }
        }
        if(result.size() == 4) {
            for(int i: result) {
                sum += i;
            }
        }
        return sum;
    }

    public int sumOfDivisorsOptimal(int n) {
        int sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1; i*i<=n; i++) {
            if(n % i == 0) {
                result.add(i);
                if(i != n/i) {
                    result.add(n/i);
                }
            }
        }
        if(result.size() == 4) {
            for(int i: result) {
                sum += i;
            }
        }
        return sum;
    }

}
