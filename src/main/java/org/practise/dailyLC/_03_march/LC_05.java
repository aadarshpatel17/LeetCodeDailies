package org.practise.dailyLC._03_march;

public class LC_05 {

    // 1758. Minimum Changes To Make Alternating Binary String

    public static void main(String[] args) {
        System.out.println(minOperations("10100"));
    }

    public static int minOperations_optimized(String s) {
        int n = s.length();
        int startsWithZero = 0;     //  4

        // 01010
        // 10101
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    startsWithZero++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    startsWithZero++;
                }
            }
        }
        return Math.min(startsWithZero, n - startsWithZero);
    }

    public static int minOperations(String s) {
        int n = s.length();
        int startsWithZero = 0;     //  4
        int startsWithOne = 0;      //  1

        // 01010
        // 10101
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    startsWithOne++;
                } else {
                    startsWithZero++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    startsWithOne++;
                } else {
                    startsWithZero++;
                }
            }
        }
        return Math.min(startsWithZero, startsWithOne);
    }

}
