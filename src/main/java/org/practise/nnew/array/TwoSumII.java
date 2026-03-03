package array;

import java.io.*;
import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        int[] nums = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        String target = br.readLine().trim();

        bw.write(Arrays.toString(twoSum(nums, Integer.parseInt(target))));

        bw.flush();
        bw.close();
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target)
                return new int[]{left + 1, right + 1};
            else if(sum < target)
                left++;
            else
                right--;
        }
        return new int[]{-1};
    }
}
