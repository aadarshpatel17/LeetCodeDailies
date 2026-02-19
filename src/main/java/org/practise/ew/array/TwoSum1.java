package array;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        int[] ar = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            ar[i] = Integer.parseInt(arr[i]);
        String target = br.readLine();

        bw.write(Arrays.toString(twoSum(ar, Integer.parseInt(target))));

        bw.flush();
        bw.close();
    }

//    2,7,11,15, t = 9
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> storedValues = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int requiredNum = target - nums[i];
            if(storedValues.containsKey(requiredNum)) {
                return new int[]{storedValues.get(requiredNum), i};
            }
            storedValues.put(nums[i], i);
        }
        return null;
    }
}
