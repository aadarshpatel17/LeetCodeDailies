package org.practise;

import java.io.*;

public class ValidMountainArray941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        int[] ar = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            ar[i] = Integer.parseInt(arr[i]);
        }

        bw.write(String.valueOf(validMountainArray(ar)));

        bw.flush();
        bw.close();
    }

    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n < 3)
            return false;

        int i =0;
        while(i+1 < n && arr[i] < arr[i+1])
            i++;
        if (i == 0 || i == n - 1) return false;
        while (i + 1 < n && arr[i] > arr[i + 1])
            i++;
        return i == n-1;
    }
}
