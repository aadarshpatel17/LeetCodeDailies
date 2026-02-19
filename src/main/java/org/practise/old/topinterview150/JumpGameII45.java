package org.practise;

import java.io.*;

public class JumpGameII45 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

        bw.write(String.valueOf(jump(nums)));

        bw.flush();
        bw.close();
    }

//    [1,2,1,1,1]
//    [2,3,1,1,4]
    public static int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        int reachable = 0;
        int jumps = 0;
        int currEnd = 0;
        for (int i = 0; i < nums.length-1; i++) {
            reachable = Math.max(reachable, i + nums[i]);
            if(i == currEnd) {
                currEnd = reachable;
                jumps++;
            }
        }
        return jumps;
    }
}
