//Other`s Work

public class Solution {  
    public double pow(double x, int n) {  
        //7  
        //421  
        boolean neg = n<0;  
        long ln = Math.abs( (long)n );  
        double product = 1.0;  
        while(ln>0) {  
            if( (ln&1) == 1) {  
                product *= x;  
            }  
            x = x*x;  
            ln >>= 1;  
        }  
        return neg ? 1.0/product : product;  
    }  
}  
