/*
  DP.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if(l<2) return 0;
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        boolean flag = false;

        for(int i=1; i<l; i++){
            if(!flag){
                if(prices[i]<=prices[i-1]) {
                    min = prices[i];
                }
                else {
                    flag = true;
                    max = prices[i];
                }
            }
            else{
                if(prices[i]>=prices[i-1]) {
                    max = prices[i];
                }
                else{
                    profit += max - min;
                    flag = false;
                    min = prices[i];
                    max = prices[i];
                }
            }
        }
        if(flag) profit += max - min;
        return profit;
    }
}
