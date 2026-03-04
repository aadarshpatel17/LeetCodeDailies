package org.practise.dailyLC._02_feb;

public class LC_19 {

    // 696. Count Binary Substrings
    public int countBinarySubstrings(String s) {
        int result = 0;
        int crt = 1;
        int prev = 0;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                crt++;
            } else {
                result += Math.min(crt, prev);
                prev = crt;
                crt = 1;
            }
        }
        return result + Math.min(prev, crt);
    }

}
