package array;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FindPivotIndex724 {
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

        bw.write(String.valueOf(pivotIndex(ar)));

        bw.flush();
        bw.close();
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixLeft = new int[n];
        int[] prefixRight = new int[n];

        prefixLeft[0] = nums[0];
        prefixRight[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++)
            prefixLeft[i] = prefixLeft[i-1] + nums[i];
        for (int i = n - 2; i >= 0; i--)
            prefixRight[i] = nums[i] + prefixRight[i + 1];
        for(int i=0; i<n; i++) {
            if(prefixLeft[i] == prefixRight[i])
                return i;
        }

        return -1;
    }
}
