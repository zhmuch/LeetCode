/*
  A more complex version.
  Can handle partial matching.
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        int ii = 0;
        while(ii < lp && p.charAt(ii) == '*')
            ii++;
        int jj = lp - 1;
        while(jj >= 0 && p.charAt(jj) == '*')
            jj--;
        if(jj < ii)
            return true;
        else
            p = p.substring(ii, jj+1);
        lp = p.length();

        boolean[][] mat = new boolean[lp][ls];
        
        for(int j=0; j<ls; j++)
            if(p.charAt(0) ==s.charAt(j))
                mat[0][j] = true;
            else
                mat[0][j] = false;
        
        for(int i=1; i<lp; i++){
            char tmp = p.charAt(i);
            if(tmp == '*'){
                boolean ex = false;
                for(int j=0; j<ls; j++)
                    if(ex)
                        mat[i][j] = true;
                    else{
                        mat[i][j] = mat[i-1][j];
                        ex = mat[i][j];
                    }
            }
            else{
                mat[i][0] = false;
                for(int j=1; j<ls; j++)
                    if( (tmp == '?' || tmp == s.charAt(j)) && mat[i-1][j-1] )
                        mat[i][j] = true;
                    else
                        mat[i][j] = false;
            }
        }
        for(int i=0; i<ls; i++)
            if (mat[lp-1][i])
                return true;
        
        return false;
    }
}
