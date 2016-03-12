import java.util.*;

public class Solution {
    public int trailingZeroes(int n) {
        if(n < 1)
            return 0;

        int l = (int) (Math.log(n) / Math.log(5));

        int count = 0;
        int tmp = 5;
        for(int i=0; i<l; i++) {
            count += n / tmp;
            tmp *= 5;
        }
        return count;
    }
}
