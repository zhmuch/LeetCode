/*
  DP.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if(l<2) return 0;
        int min = prices[0];
        int profit = 0;

        for(int i=1; i<l; i++){
            if(prices[i]<min) min = prices[i];
            else profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }
}
