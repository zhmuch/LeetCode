/*
  无敌DP.
*/

public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] m = new int[l1 + 1][l2 + 1];

        for(int j=0; j<=l2; j++)
            m[0][j] = j;

        for(int i=1; i<=l1; i++){
            m[i][0] = i;
            for(int j=1; j<=l2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    m[i][j] = Math.min( Math.min(m[i-1][j-1], m[i-1][j] + 1), m[i][j-1] + 1);
                else
                    m[i][j] = Math.min( Math.min(m[i-1][j-1] + 1, m[i-1][j] + 1), m[i][j-1] + 1);
            }
        }

        return m[l1][l2];
    }
}
