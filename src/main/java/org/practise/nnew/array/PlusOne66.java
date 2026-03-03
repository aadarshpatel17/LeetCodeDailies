package array;

import java.io.*;
import java.util.Arrays;

public class PlusOne66 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        int[] ar = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            ar[i] = Integer.parseInt(arr[i]);

        bw.write(Arrays.toString(plusOne(ar)));

        bw.flush();
        bw.close();
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n+1];
        for(int j=0; j<res.length; j++)
            res[0] = 1;
        return res;
    }
}
