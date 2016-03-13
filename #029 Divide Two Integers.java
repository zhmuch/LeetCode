import java.util.*;

public class Solution {
    public int divide(int dividend, int divisor) {
        boolean flag = true;
        if(dividend < 0)
            flag = !flag;
        if(divisor < 0)
            flag = !flag;
        if(divisor == 0)
            return flag? dividend:-dividend;

        long d1 = Math.abs((long) dividend);
//        System.out.println("d1: " + d1);
        long d2 = Math.abs((long) divisor);
//        System.out.println("d2: " + d2);

        long[] sum = new long[50];
        long[] num = new long[50];

        int i = 0;
        sum[0] = d2;
        num[0] = 1;

        while(sum[i] <= d1){
            i++;
            sum[i] = sum[i-1] + sum[i-1];
            num[i] = num[i-1] + num[i-1];
        }

        i--;

        long res = 0;
        while(i >= 0 && d1 > 0){
            if(d1 >= sum[i]){
                res += num[i];
                d1 -= sum[i];
            }
            i--;
        }

        if (res > Integer.MAX_VALUE && flag)
            res = Integer.MAX_VALUE;

        return flag ? (int)res : (int)-res;
    }
}
