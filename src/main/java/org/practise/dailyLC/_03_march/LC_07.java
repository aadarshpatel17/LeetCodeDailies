package org.practise.dailyLC._03_march;

public class LC_07 {

    // 1888. Minimum Number of Flips to Make the Binary String Alternating

    public static void main(String[] args) {
        System.out.println(minFlips_optimized("01001001101"));
    }

    public static int minFlips_optimized(String s) {
        int n = s.length();

        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        int res1 = 0, res2 = 0;

        while (j < 2 * n) {
            // expected j
            char expectedCharS1 = j % 2 == 0 ? '0' : '1';
            char expectedCharS2 = j % 2 == 0 ? '1' : '0';

            // expand window
            if (s.charAt(j % n) != expectedCharS1) res1++;
            if (s.charAt(j % n) != expectedCharS2) res2++;

            // shrink window
            expectedCharS1 = i % 2 == 0 ? '0' : '1';
            expectedCharS2 = i % 2 == 0 ? '1' : '0';

            if (j - i + 1 > n) {
                if (s.charAt(i % n) != expectedCharS1) res1--;
                if (s.charAt(i % n) != expectedCharS2) res2--;
                i++;
            }

            // window size n
            if (j - i + 1 == n) {
                res = Math.min(res, Math.min(res1, res2));
            }

            j++;
        }

        return res;
    }

    public static int minFlips_better(String s) {
        int n = s.length();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        // 10101...
        // 01010...
        for (int i = 0; i < 2 * n; i++) {
            s1.append(i % 2 == 0 ? '0' : '1');
            s2.append(i % 2 == 0 ? '1' : '0');
        }

        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        int res1 = 0, res2 = 0;

        while (j < 2 * n) {
            // expand window
            if (s.charAt(j % n) != s1.charAt(j)) res1++;
            if (s.charAt(j % n) != s2.charAt(j)) res2++;

            // shrink window
            if (j - i + 1 > n) {
                if (s.charAt(i % n) != s1.charAt(i)) res1--;
                if (s.charAt(i % n) != s2.charAt(i)) res2--;
                i++;
            }

            // window size n
            if (j - i + 1 == n) {
                res = Math.min(res, Math.min(res1, res2));
            }

            j++;
        }

        return res;
    }

    public static int minFlips(String s) {
        int n = s.length();
        s = s + s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        // 01010...
        // 10101...
        for (int i = 0; i < 2 * n; i++) {
            s1.append(i % 2 == 0 ? '0' : '1');
            s2.append(i % 2 == 0 ? '1' : '0');
        }

        int i = 0, j = 0;
        int res1 = 0, res2 = 0;
        int res = Integer.MAX_VALUE;

        while (j < 2 * n) {
            //expand window
            if (s.charAt(j) != s1.charAt(j)) res1++;
            if (s.charAt(j) != s2.charAt(j)) res2++;

            // shrink window
            if (j - i + 1 > n) {
                if (s.charAt(i) != s1.charAt(i)) res1--;
                if (s.charAt(i) != s2.charAt(i)) res2--;
                i++;
            }

            // window size n
            if (j - i + 1 == n) {
                res = Math.min(res, Math.min(res1, res2));
            }
            j++;
        }
        return res;
    }


}
