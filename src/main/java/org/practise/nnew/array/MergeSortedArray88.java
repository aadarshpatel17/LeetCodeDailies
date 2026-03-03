package array;

import java.io.*;
import java.util.Arrays;

public class MergeSortedArray88 {
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
        String len1 = br.readLine().trim();

        String str2 = br.readLine();
        str2 = str2.substring(1, str2.length()-1);
        String[] arr2 = str2.trim().split(",");
        int[] ar2 = new int[arr2.length];
        for(int i=0; i<arr2.length; i++) {
            ar2[i] = Integer.parseInt(arr2[i]);
        }

        String len2 = br.readLine().trim();

        merge(ar, Integer.parseInt(len1), ar2, Integer.parseInt(len2));

        bw.flush();
        bw.close();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (j < n && (nums1[i] == 0)) {
                nums1[i] = nums2[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(bubbleSort(nums1, len)));
    }

    public static int[] bubbleSort(int[] nums, int n) {
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}
