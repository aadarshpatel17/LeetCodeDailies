package org.practise.dsa_training.day2_sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Class_340 {

    public int lengthOfLongestSubstring_trying(String s, int k) {
        if (k == 0 || s.isEmpty()) return 0;

        int maxLen = 0;
        int left = 0, right = 0;
        Map<Character, Integer> freq = new HashMap<>();

        while(right < s.length()) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while(freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if(freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

}
