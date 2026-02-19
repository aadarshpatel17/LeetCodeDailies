package org.practise;

import java.io.*;

public class BestTimeBuySellStockII122 {
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

//    [7,1,5,3,6,4]
    public static int maxProfix(int[] prices) {
        int profit = 0;
        int low = prices[0];
        for(int price: prices) {
            if(low > price)
                low = price;
            else {
                int temp = price - low;
                profit += temp;
                low = price;
            }
        }
        return profit;
    }
}
