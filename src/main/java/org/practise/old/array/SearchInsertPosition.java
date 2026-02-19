package org.practise;

import java.io.*;

public class SearchInsertPosition {
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

        int res = searchInsert(nums, Integer.parseInt(target));

        bw.write(String.valueOf(res));

        bw.flush();
        bw.close();
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == nums[mid])
                return mid;
            if(target < nums[mid])
                right = mid - 1;
            if(target > nums[mid])
                left = mid + 1;
        }
        return left;
    }
}
