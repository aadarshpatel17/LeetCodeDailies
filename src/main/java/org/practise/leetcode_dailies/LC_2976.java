package org.practise.leetcode_dailies;

import java.util.Arrays;

public class LC_2976 {

//    2976. Minimum Cost to Convert String I

    public static void main(String[] args) {
        String source = "abcd";
        String target = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = {2, 5, 5, 1, 2, 20};

        LC_2976 ref = new LC_2976();
        System.out.println(ref.minimumCost(source, target, original, changed, cost));
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] distance = new long[26][26];
        for(int i=0; i<26; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        floydWarshall(distance, original, changed, cost);

        long result = 0;
        for(int i=0; i<source.length(); i++) {
            char s = source.charAt(i);
            char t = target.charAt(i);
            if(s == t) {
                continue;
            }

            if(distance[s - 'a'][t - 'a'] == Integer.MAX_VALUE) {
                return -1;
            } else {
                result += distance[s - 'a'][t - 'a'];
            }
        }
        return result;
    }

    public void floydWarshall(long[][] distance, char[] original, char[] changed, int[] cost) {
        for (int i = 0; i < original.length; i++) {
            int s = original[i] - 'a';
            int t = changed[i] - 'a';
            distance[s][t] = Math.min(distance[s][t], (long) cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }

}
