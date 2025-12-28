package org.practise.top150.arraystring;

import java.util.Scanner;

public class FindIndexFirstOccurrenceString_28 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String haystack = sc.next();
        String needle = sc.next();
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            String sub = haystack.substring(i, i + m);
            if (sub.equals(needle))
                return i;
        }
        return -1;
    }

}
