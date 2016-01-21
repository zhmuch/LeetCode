/*
  The local array tracks maximum profit of j transactions & the last transaction is on ith day. 
  The global array tracks the maximum profit of j transactions until ith day.
*/

import java.util.*;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int l=prices.length;
        if(l<2 || k<1) return 0;
        
  //针对大k优化。
        if (k >=  n/2) {
          int maxPro = 0;
          for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i-1])
                maxPro += prices[i] - prices[i-1];
          }
          return maxPro;
        }
          
  //过滤噪声。
        int[] p = new int[l];
        int index = 0;
        int min = prices[0];
        int max = prices[0];
        boolean flag = false;

        for(int i=1; i<l; i++){
            if(!flag){
                if(prices[i]<=prices[i-1]) {
                    min = prices[i];
                }
                else {
                    p[index]=min;
                    index++;
                    flag = true;
                    max = prices[i];
                }
            }
            else{
                if(prices[i]>=prices[i-1]) {
                    max = prices[i];
                }
                else{
                    flag = false;
                    p[index]=max;
                    index++;
                    min = prices[i];
                    max = prices[i];
                }
            }
        }
        if(flag) {
            p[index]=max;
            index++;
        }
  //DP.
        int[][] local = new int[l][k+1];
        int[][] global = new int[l][k+1];
        
        for(int i=1; i<index; i++){
            int dif=p[i]-p[i-1];
            for(int j=1; j<=k; j++){
                local[i][j]=Math.max(global[i-1][j-1]+Math.max(0, dif), local[i-1][j]+dif);
                global[i][j]=Math.max(local[i][j], global[i-1][j]);
            }
        }
        
        if(index>1) {
            return global[index-1][k];
        }
        else return 0;
    }
}
