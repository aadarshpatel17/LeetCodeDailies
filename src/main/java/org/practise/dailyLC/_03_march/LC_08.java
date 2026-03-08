package org.practise.dailyLC._03_march;

public class LC_08 {

    // 1980. Find Unique Binary String

    public static void main(String[] args) {
        String[] nums = {"01","10"};
        System.out.println(findDifferentBinaryString(nums));
    }

    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = nums[i].charAt(i);
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }

}
