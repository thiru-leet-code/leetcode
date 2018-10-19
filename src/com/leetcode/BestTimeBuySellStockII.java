package com.leetcode;

import java.util.PriorityQueue;

public class BestTimeBuySellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length <2) {
            return 0;
        }
        for (int i =1; i < prices.length; i++) {
            // System.out.println("prices[i] : " + prices[i] + " prices[i-1]" + prices[i-1]);
            if (prices[i-1]< prices[i]) {
                // System.out.println("profit : " + profit);
                profit +=(prices[i] - prices[i-1]);
            }
        }
        PriorityQueue<Interval> p = new PriorityQueue<>(((a,b) -> { return a.end-b.end;}));
        Interval i = (Interval) p.toArray()[0];
        return profit;
    }

    public static void main(String[] args) {
        int[] i = {7,1,5,3,6,4};
        System.out.println((new BestTimeBuySellStockII()).maxProfit(i));
    }
}
