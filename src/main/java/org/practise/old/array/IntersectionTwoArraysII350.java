package org.practise;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionTwoArraysII350 {
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

        String str2 = br.readLine();
        str2 = str2.substring(1, str2.length()-1);
        String[] arr2 = str2.trim().split(",");
        int[] ar2 = new int[arr2.length];
        for(int i=0; i<arr2.length; i++) {
            ar2[i] = Integer.parseInt(arr2[i]);
        }

        bw.write(Arrays.toString(intersect2(ar, ar2)));

        bw.flush();
        bw.close();
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while((left < nums1.length) && (right < nums2.length)) {
            if(nums1[left] == nums2[right]) {
                list.add(nums1[left]);
                left++;
                right++;
            }
            else if(nums1[left] < nums2[right])
                left++;
            else
                right++;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int j : nums1) {
            Arrays.sort(nums2);
            int index = binarySearch(nums2, j);
            if (index != -1) {
                list.add(nums2[index]);
                nums2[index] = -1;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
