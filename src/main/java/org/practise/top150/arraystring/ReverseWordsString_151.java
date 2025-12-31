package org.practise.top150.arraystring;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ReverseWordsString_151 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        reverseWords(str);
    }

    public static String reverseWords(String s) {
        s = s.substring(1, s.length()-1).trim();
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i= words.length-1; i>=0; i--) {
            sb.append(words[i]);
            if(i != 0)  {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
