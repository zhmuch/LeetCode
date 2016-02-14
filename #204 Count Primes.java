/*
  筛法求质数。
*/
import java.util.Arrays;

public class Solution {
    public int countPrimes (int n) {
        if(n<=2) return 0;

        boolean[] pri = new boolean[n+1];
        
        for(int i=2; i*i<n; i++){
            if(!pri[i]){
                for(int j=i; i*j<n; j++){
                    pri[i*j] = true;
                }
            }
        }
        int count = 0;
        for(int i=2; i<n; i++){
            if(!pri[i]) count++;
        }
        return count;
    }
}

/*
  Time exceed, big number.
*/

public class Solution {
    public int countPrimes (int n) {
        if(n<=2) return 0;
        
        int[] pri = new int[n/2];
        pri[0] = 2; 
        int count = 1;
        
        int i = 3;
        while(i<n){
            boolean flag = true;
            for(int j=0; j<count; j++){
                if(i%pri[j] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                pri[count] = i;
                count++;
            }
            i += 2;
        }
        return count;
    }
}
