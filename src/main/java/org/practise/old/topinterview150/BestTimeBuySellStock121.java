package org.practise;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BestTimeBuySellStock121 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim().replaceAll("^\\[|\\]$", "");
        String[] parts = input.split(",\\s*");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            nums[i] = Integer.parseInt(parts[i]);

        bw.write(String.valueOf(maxProfix1(nums)));

        bw.flush();
        bw.close();
    }

    public static int maxProfix1(int[] prices) {
        int profit = 0;
        int low = prices[0];
        for(int price: prices) {
            if(low > price)
                low = price;
            else {
                int temp = price - low;
                if(temp > profit)
                    profit = temp;
            }
        }
        return profit;
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int currSmall = prices[0];
        int currSmallIndex = -1;
        for(int i=1; i<n; i++) {
            int profit = 0;
            if(prices[i-1] > prices[i]) {
                if(currSmall > prices[i]){
                    currSmallIndex = i;
                    currSmall = prices[currSmallIndex];
                }
            } else if(prices[currSmallIndex] < prices[i]) {
                profit = prices[i] - prices[currSmallIndex];
            }
            if(res < profit)
                res = profit;
        }
        return res;
    }
}
