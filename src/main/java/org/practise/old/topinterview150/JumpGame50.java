package org.practise;

import java.io.*;

public class JumpGame50 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

        bw.write(String.valueOf(maxProfix(nums)));

        bw.flush();
        bw.close();
    }

//    If using Greedy: use a variable to hold the furthest point we can reach so far,
//    ie.furthest = max(furthest, i+nums[i]).
//    Then think of a way to use it for judging if we can get to the end.

    public static boolean maxProfix(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;  // can't move to this index
            reachable = Math.max(reachable, i + nums[i]);
            if (reachable >= nums.length - 1) return true;  // early exit
        }
        return true;
    }
}
