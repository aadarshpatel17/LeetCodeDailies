package org.practise.top150;

import java.util.Scanner;

public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr = sc.nextLine().replace("[","").replace("]","").split(",");
        System.out.println(longestCommonPrefix(arrStr));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1)
            return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix))
                prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty())
                return "";
        }
        return prefix;
    }

}
