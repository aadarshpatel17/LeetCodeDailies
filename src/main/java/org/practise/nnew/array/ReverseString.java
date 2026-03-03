package array;

import java.io.*;
import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        char[] nums = new char[arr.length];
        for(int i=0; i<arr.length; i++) {
            nums[i] = arr[i].charAt(1);
        }

        reverseString(nums);

        bw.flush();
        bw.close();
    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left < right) {
            char temp =  s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
