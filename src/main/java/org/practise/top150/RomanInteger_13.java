package org.practise.top150;

import java.util.Scanner;

public class RomanInteger_13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(romanToInt(str));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        String str1 = s.replace("IV", "IIII");
        String str2 = str1.replace("IX","VIIII");
        String str3 = str2.replace("XL","XXXX");
        String str4 = str3.replace("XC","LXXXX");
        String str5 = str4.replace("CD","CCCC");
        String str = str5.replace("CM","DCCCC");

        for(int i=0; i<str.length(); i++) {
            char l = str.charAt(i);
            switch(l) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }

        return sum;
    }

}
