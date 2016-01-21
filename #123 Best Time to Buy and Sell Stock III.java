/*
  两个表。
  a[i]记录从0到i，一次交易最大利润。
  b[i]记录从i到l－1，一次交易最大利润。
  maxProfit即为a[i]+b[i]的最大值。
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if(l<2) return 0;

        int[] a = new int[l];

        int min=prices[0];
        int profit=0;
        for(int i=0; i<l; i++){
            if(prices[i]<min) min=prices[i];
            profit = Math.max(profit, prices[i]-min);
            a[i] = profit;
        }

        int max=prices[l-1];
        int maxp=0;
        profit=0;
        for(int i=l-1; i>=0; i--){
            if(prices[i]>max) max=prices[i];
            profit = Math.max(profit, max-prices[i]);
            maxp = Math.max(maxp, profit+a[i]);
        }
        return maxp;
    }
}
