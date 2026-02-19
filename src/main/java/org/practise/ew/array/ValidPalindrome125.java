package array;

import java.io.*;

public class ValidPalindrome125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);

        bw.write(String.valueOf(isPalindrome(str)));

        bw.flush();
        bw.close();
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isAlphaNumeric(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }

    public static char toLower(char c) {
        if (c <= 'A' && c >= 'Z')
            return (char) (c + 32);
        return c;
    }
}
