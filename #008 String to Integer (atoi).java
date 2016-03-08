import java.util.*;

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();

        int l = str.length();

        if(l<1)
            return 0;

        int pos = 0;
        int neg = 0;

        int sent = 0;
        while(sent < l){
            char tmp = str.charAt(sent);
            if(tmp == '-')
                neg ++;
            else if(tmp == '+')
                pos ++;
            else
                break;
            sent++;
        }

        if(sent == l)
            return 0;
        str = str.substring(sent);

        l = str.length();
        long bound = Integer.MAX_VALUE;
        long bb = bound + bound;

        long res = 0;
        for(int i=0; i<l; i++){
            char tmp = str.charAt(i);
            int t = tmp - '0';
            if(t >= 0 && t<= 9)
                res = res * 10 + t;
            else break;

            if(res > bb)
                break;
        }


        boolean positive = true;

        if(pos == 0 && neg == 0)
            positive = true;

        else if (pos + neg >= 2)
            return 0;
        else if(pos == neg)
            return 0;
        else if(pos > neg)
            positive = true;
        else if(neg % 2 == 0)
            positive = true;
        else
            positive = false;


        if(positive){
            if(res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return (int)res;
        }
        else{
            bound ++;
            if(res > bound)
                return -(Integer.MAX_VALUE + 1);
            else
                return -(int)res;
        }
    }
}
