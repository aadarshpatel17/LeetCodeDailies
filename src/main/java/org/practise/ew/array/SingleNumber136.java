package array;

import java.io.*;
import java.util.Arrays;

public class SingleNumber136 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        int[] ar = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            ar[i] = Integer.parseInt(arr[i]);

        bw.write(String.valueOf(singleNumber(ar)));

        bw.flush();
        bw.close();
    }

    public static int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

//        [1,1,2,2,4]
        System.out.println(Arrays.toString(nums));
        for(int i=1; i<n; i+=2) {
            if(nums[i] != nums[i-1])
                return nums[i-1];
        }

        return nums[n-1];
    }
}
