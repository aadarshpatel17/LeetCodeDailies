package org.practise.top150;

public class LC_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int furthest = 0;
        for(int i=0;i<n; i++) {
            if (i > furthest) return false;
            furthest = Math.max(furthest, i+nums[i]);
            if (furthest >= nums.length - 1)
                return true;
        }
        return false;
    }

    public int canJump2(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int furthest = 0;
        int jump = 0;
        int currentEnd = 0;
        for(int i=0;i<n-1; i++) {
            furthest = Math.max(furthest, i+nums[i]);
            if(i == currentEnd) {
                jump++;
                currentEnd = furthest;
            }
        }
        return jump;
    }
}
