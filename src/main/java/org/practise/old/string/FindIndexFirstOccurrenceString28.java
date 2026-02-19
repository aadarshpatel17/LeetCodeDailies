package org.practise;

import java.io.*;

public class FindIndexFirstOccurrenceString28 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        String input = br.readLine();
//        input = input.substring(1, input.length()-1);
//        String[] stringArray = input.trim().split(",");

        String haystack = br.readLine().trim();
        String needle = br.readLine().trim();
        bw.write(String.valueOf(strStr1(haystack, needle)));

        bw.flush();
        bw.close();
    }

    public static int strStr1(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i=0; i<=n-m; i++) {
            String sub = haystack.substring(i, i+m);
            if(sub.equals(needle))
                return i;
        }
        return -1;
    }

//    brute-force
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        int count = 0;
        int res = -1;
        for(int i=0; i<=n-m; i++) {
            int temp = i;
            for(int j=0; j<m; j++) {
                if(haystack.charAt(i) == needle.charAt(j)) {
                    count++;
                    if(res < i && count == 1)
                        res = i;
                    i++;
                } else {
                    res = -1;
                    i = temp;
                    count = 0;
                    break;
                }
            }
            if(count > 0)
                return res;
        }
        return -1;
    }
}
