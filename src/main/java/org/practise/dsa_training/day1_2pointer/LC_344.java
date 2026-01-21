package org.practise.dsa_training.day1_2pointer;

public class LC_344 {

    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int n = s.length;
        int left = 0;
        int right = n-1;
        while(left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}
