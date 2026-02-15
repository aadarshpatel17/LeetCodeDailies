package org.practise.leetcode_dailies;

import java.math.BigInteger;

public class LC_67 {
    //    67. Add Binary
    public String addBinary(String a, String b) {
        BigInteger n1 = new BigInteger(a, 2);
        BigInteger n2 = new BigInteger(b, 2);
        BigInteger sum = n1.add(n2);
        return sum.toString(2);
    }

    public String addBinary_approachII(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        int sum = 0;

        StringBuilder result = new StringBuilder();
        while(m >=0 || n >= 0) {
            sum = carry;
            if(m >= 0) {
                sum += a.charAt(m) - '0';
                m--;
            }
            if(n >= 0) {
                sum += b.charAt(n) - '0';
                n--;
            }

            result.append((sum % 2 ==0) ? '0' : '1');
            carry = sum/ 2;
        }
        if(carry == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }

}
