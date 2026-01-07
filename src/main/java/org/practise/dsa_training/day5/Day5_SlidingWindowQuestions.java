package org.practise.dsa_training.day5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day5_SlidingWindowQuestions {
    // 567. Permutation in String
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // freq of s1 char's
        for(char ch: s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<s2.length(); i++) {
            char rightChar = s2.charAt(i);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // Remove the leftmost char if window is bigger than s1
            if(i >= s1.length()) {
                char leftChar = s2.charAt(i - s1.length());
                if(windowMap.get(leftChar) == 1) {
                    windowMap.remove(leftChar);
                } else {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
            }

            // Now, windowMap contains frequency of current window of length s1
            if(windowMap.equals(s1Map)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkInclusion_Optimized(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len2 < len1) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Fill s1 frequency
        for (char ch : s1.toCharArray()) {
            s1Count[ch - 'a']++;
        }

        // Sliding window
        for (int i = 0; i < len2; i++) {
            // Add right character to window
            windowCount[s2.charAt(i) - 'a']++;

            // Remove left character if window is bigger than s1
            if (i >= len1) {
                windowCount[s2.charAt(i - len1) - 'a']--;
            }

            // Compare window with s1
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }

}
