package org.practise;

import java.io.*;
import java.util.Arrays;

public class ValidParentheses20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
//        input = input.substring(1, input.length()-1);
//        String[] stringArray = input.trim().split(",");

        bw.write(String.valueOf(isValid(input)));

        bw.flush();
        bw.close();
    }

//    brute-force
    public static boolean isValid(String s) {
        int len = s.length();
        if(len < 2)
            return false;

        int parenthesisCount = 0;
        int curlyBrasisCount = 0;
        int sqaureBracketCount = 0;

        for(int i=0; i<len; i++) {
            if(s.charAt(i) == '(')
                parenthesisCount++;
            else if (s.charAt(i) == ')')
                parenthesisCount--;
            else if (s.charAt(i) == '{')
                curlyBrasisCount++;
            else if (s.charAt(i) == '}')
                curlyBrasisCount--;
            else if (s.charAt(i) == '[')
                sqaureBracketCount++;
            else if (s.charAt(i) == ']')
                sqaureBracketCount--;
        }

        if( (parenthesisCount==0) && (curlyBrasisCount==0) && (sqaureBracketCount==0) )
            return true;
        return false;
    }
}
