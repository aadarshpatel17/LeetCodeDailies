package org.practise.striver.dsasheet.arrays.mid;

public class LC_121 {

//    121. Best Time to Buy and Sell Stock

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
