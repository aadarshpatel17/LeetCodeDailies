package org.practise.top150.arraystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MajorityElement_169 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input: array
        String[] arrStr = sc.nextLine().replace("[","").replace("]","").split(",");
        int[] nums = new int[arrStr.length];
        for(int i=0; i<arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }

        System.out.println(majorityElement_BF(nums));
    }

    // Buyer-Moore Voting Algorithm : MOST OPTIMAL
    /*
    * Core Idea (Simple)
        Cancel out different elements
        Majority element cannot be fully cancelled
        Final candidate is the answer
    * */
    public static int buyerMooreVotingAlgo(int[] nums) {
        int candidate = 0, count = 0;
        for(int num: nums) {
            if(count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }


    // using HashMap
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if(freq.get(num) > n/2) {
                return num;
            }
        }
        return -1;
    }

    // brute force approach
    public static int majorityElement_BF(int[] nums) {
        int n = nums.length;
        List<Integer> alreadyCounted = new ArrayList<>();
        int maxCount = 0;
        int majorElement = -1;

        for(int i=0; i<n; i++) {
            int count = 1;
            for(int j=0; j<n; j++) {
                if(alreadyCounted.contains(nums[i])) {
                    break;
                }
                if(i != j && nums[i] == nums[j]) {
                    count++;
                }
            }
            alreadyCounted.add(nums[i]);
            if(maxCount < count) {
                majorElement = nums[i];
                maxCount = count;
            }
        }

        return majorElement;
    }

}
