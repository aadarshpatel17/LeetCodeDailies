package org.practise.dailyLC._02_feb;

public class LC_28 {

    // 1680. Concatenation of Consecutive Binary Numbers
    public static void main(String[] args) {
        System.out.println(concatenatedBinary(12));
    }

    public static int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long result = 0;
        for(int i=1; i<=n; i++) {
            int bits = Integer.toBinaryString(i).length();
            result = (result << bits | i) % MOD;
        }
        return (int )result;
    }

}
