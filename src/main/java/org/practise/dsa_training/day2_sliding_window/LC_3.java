package org.practise.dsa_training.day2_sliding_window;

import java.util.HashSet;

public class LC_3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLen = 0, len= 0;
        HashSet<Character> longestSubString = new HashSet<>();

        while(right < s.length()) {
            if(!longestSubString.contains(s.charAt(right))) {
                longestSubString.add(s.charAt(right));
                len++;
                right++;
            } else {
                while(longestSubString.contains(s.charAt(right))) {
                    longestSubString.remove(s.charAt(left));
                    left++;
                    len--;
                }
            }
            maxLen = Math.max(maxLen,len);
        }

        return maxLen;
    }



}
