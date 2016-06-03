//  Some bugs;


import java.util.*;

public class Solution {

    String num;

    public boolean isAdditiveNumber(String num) {

        if(num == null || num.length() < 3)
            return false;

        this.num = num;
        int max = Math.min(num.length() / 2, 9);

        for(int i = 0; i < max; i++)
            for(int j = 0; j < max; j++){
                int prepre = Integer.parseInt(num.substring(0, i + 1));
                int pre = Integer.parseInt(num.substring(i + 1, i + j + 2));
                if(dfs(prepre, pre, Math.max(i, j) + 1, i + j + 2))
                    return true;
            }

        return false;
    }

    private boolean dfs(int prepre, int pre, int digits, int idx) {
        
        // System.out.println(prepre + "  " + pre + "  " + digits + "  " + idx);
        
        if(idx >= num.length())
            return true;
        
        if(num.charAt(idx) == '0' && digits > 1)
            return false;

        if(num.length() - idx < digits)
            return false;
        
        boolean res = false;
        
        //  digits
        int pos = Integer.parseInt(num.substring(idx, idx + digits));
        if(pos == prepre + pre)
            res = dfs(pre, pos, digits, idx + digits);
        
        if(res)
            return res;
        
        //  digits + 1;
        if(idx + digits + 1 <= num.length() && digits < 9){
            int poss = Integer.parseInt(num.substring(idx, idx + digits + 1));
            if(poss == prepre + pre)
                res = dfs(pre, poss, digits + 1, idx + digits + 1);
        }
        
        
        return res;
    }
}
