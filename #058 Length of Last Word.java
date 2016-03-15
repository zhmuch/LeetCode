import java.util.*;

public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int l = s.length();
        int sum = 0;

        for(int i=0; i<l; i++){
            if(s.charAt(i) == ' ') {
                if(sum != 0)
                    res = sum;
                sum = 0;
            }
            else
                sum++;
        }
        
        if(sum != 0)
            return sum;
        else
            return res;
    }
}
