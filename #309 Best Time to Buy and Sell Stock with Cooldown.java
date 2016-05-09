import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length <= 0)
            return 0;

        int l = prices.length;

        int[] buy = new int[l + 1];
        int[] sell = new int[l + 1];
        int[] cool = new int[l + 1];
        buy[0] = Integer.MIN_VALUE;

        for(int i = 1; i <= l; i++){
            buy[i] = Math.max(buy[i - 1], cool[i - 1] - prices[i - 1]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1]);
            cool[i] = Math.max(cool[i - 1], Math.max(sell[i - 1], buy[i - 1]));
        }

        return Math.max(Math.max(buy[l], sell[l]), cool[l]);

    }
}
