import java.util.*;

public class Solution {
    public int integerBreak(int n) {
        
        int[] mat;
        
        if(n <= 6)
            mat = new int[7];
        else
            mat = new int[n + 1];
        
        mat[1] = 0;
        mat[2] = 1;
        mat[3] = 2;
        mat[4] = 4;
        mat[5] = 6;
        mat[6] = 9;
        
        for(int i = 7; i <= n; i++)
            mat[i] = Math.max(mat[i-2]*2, mat[i-3]*3);

        return mat[n];
        
    }
}
