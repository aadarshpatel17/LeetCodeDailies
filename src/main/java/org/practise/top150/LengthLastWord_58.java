package org.practise.top150;

import java.util.Arrays;
import java.util.Scanner;

public class LengthLastWord_58 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(lengthOfLastWord(str));
    }

    public static int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length()-1;
        while(i>=0 && s.charAt(i) == ' ') {
            i--;
        }
        while(i>=0 && s.charAt(i) != ' '){
            len++;
            i--;
        }
        return len;
    }
}
