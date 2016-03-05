/*
  Most boring problem in Leetcode.
*/

import java.util.*;

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int l = s.length();
        if(l == 0)
            return false;

        if(s.charAt(0) == 'e' || s.charAt(l-1) == 'e')
            return false;
        String[] str = s.split("e");

        if(str.length < 1 || str.length > 2)
            return false;

        boolean res = isValid(str[0], true);
        if (str.length > 1)
            res = res && isValid(str[1], false);

        return res;
    }

    public boolean isValid(String s, boolean dotValid) {
        int l = s.length();
        
        if (s.charAt(0)=='-' || s.charAt(0)=='+'){
            s = s.substring(1);
            l--;
        }
        if(l == 0)
            return false;

        int dot = -1;

        for(int i=0; i<l; i++){
            char t = s.charAt(i);

            if(t == '.') {
                if(dotValid){
                    dotValid = false;
                    dot = i;
                }
                else{
                    return false;
                }
                continue;
            }

            if(t-'0'<0 || t-'0'>9){
                return false;
            }
        }

        if (dot == 0 && l == 1)
            return false;
        else
            return true;
    }
}
