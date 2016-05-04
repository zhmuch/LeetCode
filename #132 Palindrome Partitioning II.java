import java.util.*;

public class Solution {
    public int minCut(String s) {
    
        int len = s.length();

        if(len < 1)
            return 0;

        int[] min = new int[len + 1];
        boolean[][] isP = new boolean[len + 1][len + 1];

        for(int i = 1; i <= len; i++)
            isP[i][i] = true;

        min[0] = 0;

        for(int i = 1; i <= len; i++){
            min[i] = min[i - 1] + 1;

            for(int j = i - 1; j > 0; j--){
                if(s.charAt(j - 1) == s.charAt(i - 1))
                    if(j == i - 1 || isP[j + 1][i - 1]){
                        isP[j][i] = true;
                        min[i] = Math.min(min[i], min[j - 1] + 1);
                    }
            }
        }

        return min[len] - 1;

    }
}
