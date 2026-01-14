package org.practise.codewitharyansheet.array.easy;

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int price: prices) {
            minPrice = Math.min(minPrice, price);
            max = Math.max(max, price - minPrice);
        }
        return max;
    }
}
