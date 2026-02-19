package org.practise;

import java.io.*;

public class NumberSpiral {
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while(t-- > 0) {
            String[] parts = br.readLine().split(" ");
            long y = Long.parseLong(parts[0]);
            long x = Long.parseLong(parts[1]);
            long max = Math.max(y, x);
            long res = 0;

//            if max is even
            if(max % 2 == 0) {
                if(y == max)
                    res =  (max * max) - x + 1;
                else
                    res = (max-1) * (max-1) + y;
            }
//            if max is odd
            if(max % 2 != 0) {
                if(x == max)
                    res =  (max * max) - y + 1;
                else
                    res = (max-1) * (max-1) + x;
            }
            output.append(res).append("\n");
        }
        bw.write(output.toString());
        bw.flush();
    }
}
