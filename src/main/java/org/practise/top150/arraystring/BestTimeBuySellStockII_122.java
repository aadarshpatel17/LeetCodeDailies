package org.practise.top150.arraystring;

import java.util.Scanner;

public class BestTimeBuySellStockII_122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input: array
        String[] arrStr = sc.nextLine().replace("[","").replace("]","").split(",");
        int[] prices = new int[arrStr.length];
        for(int i=0; i< arrStr.length; i++) {
            prices[i] = Integer.parseInt(arrStr[i].trim());
        }
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
