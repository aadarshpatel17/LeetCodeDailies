package org.practise.dailyLC._02_feb;

public class LC_18 {

    // 693. Binary Number with Alternating Bits
    public boolean hasAlternatingBits(int n) {
        int result = n ^ (n >> 1);
        return (result & (result + 1)) == 0;
    }

}
