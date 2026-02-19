package org.practise.old.topinterview150;

import java.io.*;

public class Leetcode2894 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        System.out.println(differenceOfSumsOpti(n, m));
    }

    public static int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;

        for(int i=1; i<=n; i++) {
//            sum of all ints that are not divisible by m;
            if(i % m != 0)
                num1 += i;
//            sum of all ints that are divisible by m;
            else
                num2 += i;

        }
        return num1 - num2;
    }

    public static int differenceOfSumsOpti(int b, int v) {
        int k = b / v;
        return (b * (b + 1)) / 2 - k * (k + 1) * v;
    }
}
