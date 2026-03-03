package array;

import java.io.*;
import java.util.Arrays;

public class MergeSortedArray {
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
        String m = br.readLine().trim();

        String str1 = br.readLine();
        str1 = str1.substring(1, str1.length()-1);
        String[] arr1 = str1.trim().split(",");
        int[] nums1 = new int[arr.length];
        for(int i=0; i<arr1.length; i++) {
            nums1[i] = Integer.parseInt(arr1[i]);
        }
        String n = br.readLine().trim();

        merge(nums, Integer.parseInt(m), nums1, Integer.parseInt(n));

        bw.flush();
        bw.close();
    }

    public static void mergeOpti(int[] nums1, int m, int[] nums2, int n) {
        for(int j=0, i=m; j<n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int j=0;
        for(int i=0; i<len; i++) {
            if(j < n && nums1[i] == 0) {
                nums1[i] = nums2[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(bubbleSort(nums1, len)));
    }

    public static int[] bubbleSort(int[] arr, int n) {
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
