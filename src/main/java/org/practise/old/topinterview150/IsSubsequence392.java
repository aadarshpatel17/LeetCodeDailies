package org.practise;

import java.io.*;

public class IsSubsequence392 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        String input = br.readLine();
//        input = input.trim().replaceAll("^\\[|\\]$", "");
//        String[] parts = input.split(",\\s*");
//        int[] nums = new int[parts.length];
//        for (int i = 0; i < parts.length; i++)
//            nums[i] = Integer.parseInt(parts[i]);

        String input1 = br.readLine();
        String input2 = br.readLine();
        String s = input1.substring(1, input1.length()-1);
        String t = input2.substring(1, input2.length()-1);


        bw.write(String.valueOf(isSubsequence(s, t)));

        bw.flush();
        bw.close();
    }

    public static boolean isSubsequenceNaive(String s, String t) {
        int count = 0;
        int temp = 0;
        for(int i=0; i<s.length(); i++) {
            for(int j=temp; j<t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    temp = j+1;
                    count++; break;
                }
            }
        }
        return s.length() == count;
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.length() < 1)
            return true;
        if(t.length() < 1)
            return false;

        int left = 0; int right = 0;
        while(left < s.length() && right < t.length()) {
            if(s.charAt(left) == t.charAt(right))
                left++;
            right++;
        }
        return left == s.length();
    }
}
