import java.util.*;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length <= 0 || amount < 0)
            return -1;

        int[] res = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            res[i] = -1;
            int tmp = Integer.MAX_VALUE;
            for(int j : coins)
                if(i - j >= 0 && res[i - j] != -1)
                    tmp = Math.min(tmp, res[i - j] + 1);
            if(tmp != Integer.MAX_VALUE)
                res[i] = tmp;
        }

        return res[amount];
    }
}
