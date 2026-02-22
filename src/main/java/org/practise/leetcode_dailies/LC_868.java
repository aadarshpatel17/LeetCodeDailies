package org.practise.leetcode_dailies;

public class LC_868 {

    public static void main(String[] args) {
        System.out.println(binaryGap_optimized(22));
    }

    // 868. Binary Gap

    public static int binaryGap_optimized(int n) {
        boolean seenOne = false;
        int maxGap = 0;
        int position = 0;
        int currentPosition = 0;
        while(n > 0) {
            int lastBit = n & 1;
            if(lastBit == 1) {
                if(seenOne) {
                    maxGap = Math.max(maxGap, position - currentPosition);
                }
                seenOne = true;
                currentPosition = position;
            }
            n /= 2;
            position++;
        }
        return maxGap;
    }


    public static int binaryGap(int n) {
        int result = 0;
        String binary = binaryString(n);
//        String binary = Integer.toBinaryString(n);  // built-in function
        int len = binary.length();
        int left = 0, right = 0;
        while (right < len) {
            while (left < len && binary.charAt(left) != '1') {
                left++;
            }
            right = left + 1;
            while (right < len && binary.charAt(right) != '1') {
                right++;
            }
            if(right < len && binary.charAt(left) == '1' && binary.charAt(right) == '1')
                result = Math.max(result, right - left);
            left = right;
        }
        return result;
    }

    public static String binaryString(int n) {
        if (n == 0) return "0";
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        return binary.toString();
    }

}
