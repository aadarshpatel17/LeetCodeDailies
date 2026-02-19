package org.practise;

import java.io.*;

public class LongestCommonPrefix14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.substring(1, input.length()-1);
        String[] stringArray = input.trim().split(",");

        bw.write(longestCommonPrefixOptimize(stringArray));

        bw.flush();
        bw.close();
    }

//    brute-force
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n < 1)
            return "";
        String res = strs[0];
        for(int i=1; i<n; i++) {
            int len = Math.min(strs[i-1].length(), strs[i].length());
            String prefix = "";
            for(int j=0; j<len; j++) {
                if (strs[i - 1].charAt(j) == strs[i].charAt(j))
                    prefix = prefix + "" + strs[i].charAt(j);
                else
                    break;
            }
            if(prefix.length() <= res.length())
                res = prefix;
        }
        return res;
    }

    public static String longestCommonPrefixOptimize(String[] strs) {
        if (strs.length < 1)
            return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty())
                return "";
        }
        return prefix + "\"";
    }

}
