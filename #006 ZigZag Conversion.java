import java.util.*;

public class Solution {
    public String convert(String s, int numRows) {
        int l = s.length();
        String res = "";
        int sum = (numRows - 1) * 2;
        if(numRows < 2)
            return s;
            
        int j = 0;
        while(j < l){
            res = res + s.charAt(j);
            j += sum;
        }

        for(int i=1; i<numRows-1; i++){
            boolean t = true;
            int k = i;
            int d1 = sum - 2 * i;
            int d2 = 2 * i;

            while(k < l){
                res = res + s.charAt(k);
                if(t)
                    k += d1;
                else
                    k += d2;
                t = !t;
            }
        }

        j = numRows - 1;
        while(j < l){
            res = res + s.charAt(j);
            j += sum;
        }

        return res;
    }
}
