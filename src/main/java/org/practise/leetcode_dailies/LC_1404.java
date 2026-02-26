package org.practise.leetcode_dailies;

public class LC_1404 {

    // 1404. Number of Steps to Reduce a Number in Binary Representation to One
    public static void main(String[] args) {
        System.out.println(numSteps_optimized("1101"));
    }

    public static int numSteps_optimized(String s) {
        int n = s.length();

        int steps = 0;
        int carry = 0;

        for(int i=n-1; i>=1; i--) {
            if(((s.charAt(i) - '0') + carry) % 2 == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;

            }
        }

        return steps + carry;
    }

    public static int numSteps_correct(String s) {
        int steps = 0;
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 1) {
            int n = sb.length();
            // even
            if (sb.charAt(n - 1) == '0') {
                sb.deleteCharAt(n - 1);
            } else {
                sb = addOne(sb);
            }
            steps++;
        }

        return steps;
    }

    public static StringBuilder addOne(StringBuilder sb) {
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) != '0') {
            sb.replace(i,i+1, "0");;
            i--;
        }
        if (i < 0) {
            sb.insert(0, '1');
        } else {
            sb.replace(i,i+1, "1");;
        }
        return sb;
    }

    public static int numSteps(String s) {
        int num = Integer.parseInt(s, 2);
        int steps = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num += 1;
            }
            steps++;
        }
        return steps;
    }

}
