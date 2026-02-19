package org.practise;

import java.io.*;

public class Permutations {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();

        if (n == 1)
            System.out.println("1");
        if (n == 2 || n == 3)
            System.out.println("NO SOLUTION");
        if (n >= 4) {
            for (long i = 2; i <= n; i += 2)
                sb.append(i).append(" ");
            for (long i = 1; i <= n; i += 2)
                sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();

    }
}
