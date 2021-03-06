//  Bloody fast, other`s;
public class Solution {
public boolean isMatch(String s, String p) {
        char p_ar[] = p.toCharArray();
        char s_ar[] = s.toCharArray();
        int save_i, save_j, i, j;
        save_i = save_j = -1;
        i = j = 0;
        while(i < s_ar.length){
            if(j < p_ar.length && (s_ar[i] == p_ar[j] || p_ar[j] == '?')){
                ++i;
                ++j;
            }else if(j < p_ar.length && p_ar[j] == '*'){
                save_i = i + 1;
                save_j = j;
                ++j;
            }else if(save_i != -1){
                i = save_i;
                j = save_j;
            }else return false;
        }
        while(j < p_ar.length)if(p_ar[j++] != '*')return false;
        return i == s_ar.length && j == p_ar.length;
    }

}


/*
  Greedy Algorithm.
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();  
        int plen = p.length();  
        int i = 0, j=0;  
        int star = -1;  
        int sp = 0;  
        while(i<slen){  
            while(j<plen && p.charAt(j)=='*'){  
                star = j++;  
                sp = i;  
            }  
            if( j==plen || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?') ){  
                if(star<0) return false;  
                else {  
                    j = star+1;  
                    i = sp++; 
                }  
            }else {  
                i++;  
                j++;
            }  
        }  
        while(j<plen && p.charAt(j)=='*'){  
            j++;  
        }  
        return j == plen;  
    }
}


/*
  Can be improved
*/
import java.util.*;

public class Solution {
    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();

        if(ls == lp){
            if(lp == 0)
                return true;
        }
        else{
            if(lp == 0)
                return false;
            if(ls == 0){
                int y = 0;
                while(y < lp && p.charAt(y) == '*')
                    y++;
                if(y == lp)
                    return true;
                else
                    return false;
            }
        }

        boolean[][] mat = new boolean[lp][ls+1];

        char tm = p.charAt(0);
        if(tm == '*')
            for(int j=0; j<=ls; j++)
                mat[0][j] = true;
        else{
            if(s.charAt(0) != tm && tm != '?')
                return false;
            else{
                mat[0][0] = false;
                mat[0][1] = true;
                for(int j=2; j<=ls; j++)
                    mat[0][j] = false;
            }
        }

//        for(int i=0; i<lp; i++){
//            for(int j=0; j<=ls; j++)
//                System.out.print(mat[i][j] + ", ");
//            System.out.println();
//        }
//
//        System.out.println("============");
//        System.out.println("lp: " + lp);

        for(int i=1; i<lp; i++){
            char tmp = p.charAt(i);
            
            if(mat[i-1][0] == true && tmp == '*')
                mat[i][0] = true;
            else
                mat[i][0] = false;

            if(tmp == '*'){
                boolean ex = false;
                for(int j=1; j<=ls; j++)
                    if(ex)
                        mat[i][j] = true;
                    else{
                        mat[i][j] = mat[i-1][j];
                        ex = mat[i][j];
                    }
            }
            else{
                for(int j=1; j<=ls; j++)
                    if( (tmp == '?' || tmp == s.charAt(j-1)) && mat[i-1][j-1] )
                        mat[i][j] = true;
                    else
                        mat[i][j] = false;
            }
        }

        return mat[lp-1][ls];
    }
}

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
            if(p.charAt(0) == s.charAt(j) || p.charAt(0) == '*')
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
