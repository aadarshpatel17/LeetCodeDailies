package array;

import java.io.*;
import java.util.Arrays;

public class MoveZeroes283 {
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

        moveZeroesOptimize(ar);

        bw.flush();
        bw.close();
    }

    public static void moveZeroesOptimize2(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length; i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        for(int i=index; i<nums.length; i++){
            nums[i]=0;
        }
    }

    public static void moveZeroesOptimize(int[] nums) {
        int left = 0; int right = left + 1;
        int n = nums.length;
        if(n < 2)
            System.out.println(nums);

        while(right < n) {
            if(nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            else if(nums[left] == 0 && nums[right] == 0) {
                right++;
                continue;
            }
            left++;
            right++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int left = 0; int right = left + 1;
        int n = nums.length;
        while(right < n) {
            while(nums[left] != 0) {
                left += 1;
                right = left + 1;
                if(right >= n) break;
            }
            if(right >= n) break;
            while(nums[right] == 0) {
                right++;
                if(right >= n) break;
            }
            if(right > n-1 || left > n-1)
                break;
            if(nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; right++;
            }
        }
    }
}
