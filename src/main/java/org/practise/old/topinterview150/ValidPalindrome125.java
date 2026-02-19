package org.practise;

import java.io.*;

public class ValidPalindrome125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
//        input = input.trim().replaceAll("^\\[|\\]$", "");
//        String[] parts = input.split(",\\s*");
//        int[] nums = new int[parts.length];
//        for (int i = 0; i < parts.length; i++)
//            nums[i] = Integer.parseInt(parts[i]);
//
        bw.write(String.valueOf(isPalindrome(input)));

        bw.flush();
        bw.close();
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
