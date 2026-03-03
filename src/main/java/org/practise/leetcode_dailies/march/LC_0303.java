package org.practise.leetcode_dailies.march;

public class LC_0303 {
    //1545. Find Kth Bit in Nth Binary String

    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));
    }

    public static char invert_optimize_using_recursion(int n, int k) {
        if(n == 1) {
            return '0';
        }
        int l = (int ) Math.pow(2,n) - 1;
        int mid = (int ) Math.pow(2, n-1);
        if(k == mid) return '1';
        if(k < mid) return invert_optimize_using_recursion(n-1, k);
        char res = invert_optimize_using_recursion(n -1, l - k + 1);
        return invert(res);
    }

    public static char invert(char c) {
        if(c == '0')
            return '1';
        return '0';
    }

    public static String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }

    public static String reverse(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static char findKthBit(int n, int k) {
        // n == 0 means String is always '0'
        // k == 1 means String's first value is always '0'
        if (n == 0 || k == 1) {
            return '0';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        String prev = "0";
        for (int i = 1; i < n; i++) {
            String str = "1" + reverse(invert(prev));
            sb.append(str);
            prev += str;
        }

        char result = 0;
        for(int i=0;i<sb.length(); i++) {
            if(i==k-1) {
                result = sb.charAt(i);
            }
        }
        return result;
    }

}
