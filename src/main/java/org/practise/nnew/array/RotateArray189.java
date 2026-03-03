package array;

import java.io.*;
import java.util.Arrays;

public class RotateArray189 {
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

        String target = br.readLine().trim();

        rotate(ar, Integer.parseInt(target));

        bw.flush();
        bw.close();
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // this is important, for input like [1,2] and k=3, here we are normalizing
        if(n > 1) {
            reverse(nums, n-k, n-1);
            reverse(nums, 0, n-k-1);
            reverse(nums, 0, n-1);
        }
        System.out.println(Arrays.toString(nums));

    }

    public static int[] reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp =  nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
        return nums;
    }
}
