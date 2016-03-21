/*
  Simplized Code for 2D DP.
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l1 + l2 != l3)
            return false;

        boolean[][] tab = new boolean[l1+1][l2+1];

        tab[0][0] = true;
        for(int j=1; j<=l2; j++)
            tab[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && tab[0][j-1];

        for(int i=1; i<=l1; i++){
            tab[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && tab[i-1][0];

            for(int j=1; j<=l2; j++)
                tab[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && tab[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && tab[i][j-1]);
            
        }

        return tab[l1][l2];
    }
}

/*
  2D DP.
*/
import java.util.*;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l1 + l2 != l3)
            return false;

        boolean[][] tab = new boolean[l1+1][l2+1];

        tab[0][0] = true;
        for(int j=1; j<=l2; j++)
            if(s2.charAt(j-1) == s3.charAt(j-1) && tab[0][j-1])
                tab[0][j] = true;
            else
                tab[0][j] = false;

        for(int i=1; i<=l1; i++){
            if(s1.charAt(i-1) == s3.charAt(i-1) && tab[i-1][0])
                tab[i][0] = true;
            else
                tab[i][0] = false;

            for(int j=1; j<=l2; j++)
                if(s1.charAt(i-1) != s3.charAt(i+j-1) && s2.charAt(j-1) != s3.charAt(i+j-1))
                    tab[i][j] = false;
                else if (s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-1))
                    tab[i][j] = tab[i-1][j] || tab[i][j-1];
                else if (s1.charAt(i-1) == s3.charAt(i+j-1))
                    tab[i][j] = tab[i-1][j];
                else
                    tab[i][j] = tab[i][j-1];
        }

        return tab[l1][l2];
    }
}

/*
  Recursive top-down. Without DP.
  Time Limit Exceeds.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l1 + l2 != l3)
            return false;

        if(l3 == 0)
            return true;

        if(l1 == 0)
            return s2.equals(s3);

        if(l2 == 0)
            return s1.equals(s3);

        if(s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)){
            return isInterleave(s1.substring(1, l1), s2, s3.substring(1, l3)) || isInterleave(s1, s2.substring(1, l2), s3.substring(1, l3));
        } else if(s1.charAt(0) == s3.charAt(0)){
            return isInterleave(s1.substring(1, l1), s2, s3.substring(1, l3));
        } else if(s2.charAt(0) == s3.charAt(0)){
            return isInterleave(s1, s2.substring(1, l2), s3.substring(1, l3));
        } else
            return false;
            
    }
}
