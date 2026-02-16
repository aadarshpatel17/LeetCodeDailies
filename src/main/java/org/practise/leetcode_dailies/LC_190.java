package org.practise.leetcode_dailies;

import java.math.BigInteger;

public class LC_190 {

    // 190. Reverse Bits

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for(int i=0; i<32; i++) {
            int bit = n & 1;
            result = result << 1;
            result = result | bit;
            n = n >>> 1;
        }
        return result;
    }

}
