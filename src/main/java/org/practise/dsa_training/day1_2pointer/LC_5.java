package org.practise.dsa_training.day1_2pointer;

public class LC_5 {

    public String longestPalindrome_center_expansion(String s) {
        int n = s.length();
        int maxLen = 0;
        int start = 0;
        for(int i=0; i<n; i++) {
            int oddLen = 0, evenLen = 0;
            int oddStart = 0, evenStart = 0;
            // for odd
            int left = i, right = i;
            while(left >= 0 && right < n) {
                if(s.charAt(left) == s.charAt(right)) {
                    oddLen = right - left + 1;
                    left--;
                    right++;
                    oddStart = left+1;
                } else {
                    break;
                }
            }
            if (oddLen > maxLen) {
                maxLen = oddLen;
                start = oddStart;
            }
            // for even
            left = i; right = i+1;
            while(left >= 0 && right < n) {
                if(s.charAt(left) == s.charAt(right)) {
                    evenLen = right - left + 1;
                    left--;
                    right++;
                    evenStart = left+1;
                } else {
                    break;
                }
            }
            if (evenLen > maxLen) {
                maxLen = evenLen;
                start = evenStart;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public String longestPalindrome(String s) {
        if(s.length() < 2) {
            return s;
        }
        if(s.length() == 2) {
            return String.valueOf(s.charAt(0));
        }
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                String temp = s.substring(left, right+1);
                System.out.println(temp);
                if(isPalindrome(temp)) {
                    return temp;
                }
                left++;
                right--;
            }
            left++;
            right--;
        }
        return "";
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
