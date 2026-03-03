package array;

import java.io.*;
import java.util.Arrays;

public class RemoveElement {
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
        String val = br.readLine().trim();

        int k = removeElementOpti(nums, Integer.parseInt(val));
        // Output the first k elements
        bw.write("[");
        for (int i = 0; i < k; i++)
            bw.write(nums[i] + (i <= k - 1 ? ", " : ""));
        bw.write("]");

        bw.flush();
        bw.close();
    }

    public static int removeElementOpti(int[] nums, int val) {
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 1 && nums[0] != val)
            return 1;
        if(nums.length == 1)
            return 0;

        int end = nums.length-1;
        int unique = 0;
        for(int i=0; i<nums.length; i++) {
            if(end < i)
                break;
            if(nums[i] == val) {
                while(nums[end] == val && end != i) {
                    end--;
                }
                swap(nums, i, end);
            }
            if(nums[i] != val)
                unique++;
        }
        return unique;
    }

    public static int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
