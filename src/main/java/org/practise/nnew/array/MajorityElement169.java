package array;

import java.io.*;
import java.util.Arrays;

public class MajorityElement169 {
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

        bw.write(String.valueOf(majorityElementOptimize2(ar)));

        bw.flush();
        bw.close();
    }

//    O(n)
    public static int majorityElementOptimize2(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int majorityValue = -1;
        int count = 1;
        int maxCount = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] == nums[i])
                count++;
            else
                count = 1;
            if(maxCount < count) {
                maxCount = count;
                majorityValue = nums[i];
            }
        }
        return majorityValue;
    }

//    O(n)
//    failed for input: [10,9,9,9,10]
    public static int majorityElementOptimize(int[] nums) {
        int majorityValue = -1;
        int count = -1;
        int[] digits = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int j = 0; j < nums.length; j++)
            digits[nums[j]]++;

        for(int i=0; i<10; i++) {
            if(digits[i] > count) {
                count = digits[i];
                majorityValue = i;
            }
        }
        return majorityValue;
    }


//    O(n^2)
    public static int majorityElement(int[] nums) {
        int maxCount = 0;
        int majorityValue = 0;
        for(int i=0; i<nums.length; i++) {
            int count = 1;
            for(int j=0; j<nums.length; j++) {
                if(nums[j] == nums[i] && i != j)
                    count++;
            }
            if(maxCount < count) {
                maxCount = count;
                majorityValue = nums[i];
            }
        }
        return majorityValue;
    }
}
