import java.util.*;

public class Solution {
    public int reverse(int x) {
        if(x == 0)
            return 0;

        boolean pos = true;
        if(x < 0){
            pos = false;
            if(x < -Integer.MAX_VALUE)
                return 0;
            x = -x;
        }

        int[] tmp = new int[10];

        int i = 0;
        while(x != 0){
            tmp[i] = x % 10;
            x /= 10;
            i++;
        }
        int j = 0;
        while(tmp[j] == 0)
            j++;

        int res = 0;
        if((i-j) == 10) {
            for (int k = j; k < 9; k++)
                res = res * 10 + tmp[k];
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && Integer.MAX_VALUE%10 == tmp[9]))
                return 0;
            res = res * 10 + tmp[9];

        }
        else
            for (int k = j; k < i; k++)
                res = res * 10 + tmp[k];


        if(res < 0)
            return 0;
        if(pos)
            return res;
        else
            return -res;
    }
}
