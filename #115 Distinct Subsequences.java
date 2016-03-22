/*
  无敌DP.
*/

public class Solution {
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();

        int[][] m = new int[lt+1][ls+1];
        for(int j=0; j<=ls; j++)
            m[0][j] = 1;

        for(int i=1; i<=lt; i++){
            m[i][0] = 0;

            for(int j=1; j<=ls; j++)
                if(s.charAt(j-1) != t.charAt(i-1))
                    m[i][j] = m[i][j-1];
                else
                    m[i][j] = m[i][j-1] + m[i-1][j-1];
        }
        
        return m[lt][ls];
    }
}
