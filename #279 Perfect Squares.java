import java.util.*;

public class Solution {
    public int numSquares(int n) {

        int[] res = new int[n + 1];
        
        res[1] = 1;
        
        for(int i=2; i<=n; i++){
            int m = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=m; j++) {
                min = Math.min(min, res[i - j * j] + 1);
            }
            res[i] = min;
        }

        return res[n];
    }
}
