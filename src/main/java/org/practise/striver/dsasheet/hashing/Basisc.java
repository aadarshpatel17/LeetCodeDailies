package org.practise.striver.dsasheet.hashing;

import java.util.HashMap;
import java.util.Map;

public class Basisc {

//    Count frequency of each element in the array
//    Find the highest/lowest frequency element

    public static void main(String[] args) {
        int[] nums = {10,5,10,15,10,5};

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each element in the array
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Find the highest/lowest frequency element
        int highestCount = Integer.MIN_VALUE;
        int lowestCount = Integer.MAX_VALUE;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;0
        for(Map.Entry<Integer, Integer> map : freq.entrySet()) {
            int num = map.getKey();
            int count = map.getValue();
            if(count > highestCount || (count == highestCount && num > highest)) {
                highest = num;
                highestCount = count;
            }
            if(count < lowestCount || (count == lowestCount && num < lowest)) {
                lowest = num;
                lowestCount = count;
            }
        }

        System.out.println(freq);
        System.out.println("Highest: " + highest + "  Lowest: " + lowest);

    }


}
