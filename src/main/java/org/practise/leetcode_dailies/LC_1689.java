package org.practise.leetcode_dailies;

public class LC_1689 {

    // 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
    }

    public static int minPartitions_optimize(String n) {
        char maxCh = '0';
        for(char ch: n.toCharArray()) {
            maxCh = (char ) Math.max(maxCh, ch);
        }
        return maxCh - '0';
    }

    public static int minPartitions(String n) {
        int count = 0;
        char[] arr = n.toCharArray();
        while(true) {
            boolean changed = false;
            for(int i=0; i<arr.length; i++) {
                if(arr[i] != '0') {
                    arr[i]--; // subtract 1
                    changed = true;
                }
            }
            if(!changed) break;
            count++;
        }
        return count;
    }

}
