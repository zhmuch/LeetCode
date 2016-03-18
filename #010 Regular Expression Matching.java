/*
  DP.
  Be careful with Corner Case.
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        if(lp == 0){
            if(ls == 0)
                return true;
            else
                return false;
        }

        boolean[] isPre = new boolean[lp];
        for(int i=1; i<lp; i++)
            if(p.charAt(i) == '*'){
                if(isPre[i-1])
                    isPre[i] = false;
                else
                    isPre[i] = true;
            }

        boolean[][] mat = new boolean[lp][ls+1];
        //First Line.
        if(ls != 0){
            if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                mat[0][1] = true;
        }
        
        for(int i=1; i<lp; i++) {
            if(isPre[i]) {
                if (i == 1){
                    mat[i][0] = true;
                    for (int j = 0; j < ls; j++) {
                        if( (p.charAt(0) == s.charAt(j) || p.charAt(0) == '.') && mat[1][j] )
                            mat[1][j+1] = true;
                        else
                            mat[1][j+1] = false;
                    }

                }
                else{
                    mat[i][0] = mat[i - 2][0];

                    for (int j = 0; j < ls; j++) {
                        if( ((p.charAt(i-1) == s.charAt(j) || p.charAt(i-1) == '.') && (mat[i-2][j] || mat[i][j])) || mat[i-2][j+1])
                            mat[i][j+1] = true;
                        else
                            mat[i][j+1] = false;
                    }
                }
            }
            else{
                mat[i][0] = false;
                for (int j = 0; j < ls; j++) {
                    if( (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.' ) && mat[i-1][j] )
                        mat[i][j+1] = true;
                    else
                        mat[i][j+1] = false;
                }
            }
        }


        // for(int i=0; i<lp; i++)
        //     System.out.print(isPre[i] + " ");
        // System.out.println();
        // System.out.println("==========");

        // for(int i=0; i<lp; i++) {
        //     for (int j = 0; j <= ls; j++)
        //         System.out.print(mat[i][j] + " ");
        //     System.out.println();
        // }

        return mat[lp-1][ls];
    }
}
