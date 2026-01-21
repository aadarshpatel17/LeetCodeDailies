package org.practise.top150;

import java.util.Scanner;

public class LC_392 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty())
            return true;
        if(t.isEmpty())
            return false;

        int left = 0; int right = 0;
        int count = 0;
        while(left < s.length() && right < t.length()) {
            if(s.charAt(left) == t.charAt(right)) {
                count++; left++; right++;
            } else {
                right++;
            }
        }
        return count == s.length();
    }

}
