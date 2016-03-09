import java.util.*;

public class Solution {
    public int mySqrt(int x) {
        
        if(x <= 0)
            return 0;

        long left = 1;
        long right;
        if(x < 10)
            right = x;
        else
            right = x / 2;

        long mid;

        while(right - left > 1){
            mid = (left + right) / 2;
            long mm = mid * mid;
            if(mm == x)
                return (int)mid;
            else if(mm > x)
                right = mid;
            else
                left = mid;
        }
        return (int)left;
    }
}
