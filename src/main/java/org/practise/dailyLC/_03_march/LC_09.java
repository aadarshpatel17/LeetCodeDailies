package org.practise.dailyLC._03_march;

import java.util.Arrays;

public class LC_09 {

    // 3129. Find All Possible Stable Binary Arrays I

    public static int M = 1_000_000_007;
    public static int[][][] t = new int[201][201][2];

    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(2,2,2));
    }

    public static int numberOfStableArrays(int zero, int one, int limit) {
        for (int[][] a : t) for (int[] b : a) Arrays.fill(b, -1);
        int startWithOne  = solve(one, zero, 0, limit);
        int startWithZero = solve(one, zero, 1, limit);
        return (startWithOne + startWithZero) % M;
    }

    public static int solve(int onesLeft, int zerosLeft, int lastWasOne, int limit) {
        if (onesLeft == 0 && zerosLeft == 0) return 1;
        if (t[onesLeft][zerosLeft][lastWasOne] != -1)
            return t[onesLeft][zerosLeft][lastWasOne];

        int result = 0;
        if (lastWasOne == 1) { // explore 0s
            for (int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                result = (result + solve(onesLeft, zerosLeft - len, 0, limit)) % M;
            }
        } else { // explore 1s
            for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                result = (result + solve(onesLeft - len, zerosLeft, 1, limit)) % M;
            }
        }
        return t[onesLeft][zerosLeft][lastWasOne] = result;
    }


}
