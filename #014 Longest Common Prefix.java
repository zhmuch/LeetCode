import java.util.*;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int ind = 0;
        int len = strs.length;
        if(len < 1)
            return "";
        String res = "";
        
        while(true){
            if(strs[0].length() > ind){
                char tmp = strs[0].charAt(ind);
                boolean fin = false;
                for(int i=1; i<len; i++)
                    if(strs[i].length() <= ind || strs[i].charAt(ind) != tmp){
                        fin = true;
                        break;
                    }
                if(fin)
                    break;
                
                res = res + tmp;
                ind++;
                        
            }
            else 
                break;
        }
        return res;
    }
}
