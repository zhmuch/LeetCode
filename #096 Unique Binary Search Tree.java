public class Solution {
    public int numTrees(int n) {
        
        int[] mat;
        if(n > 2)
            mat = new int[n + 1];
        else
            mat = new int[3];
            
        mat[0] = 1;
        mat[1] = 1;
        mat[2] = 2;
        
        for(int i = 3; i <= n; i++)
            for(int j = 1; j <= i; j++)
                mat[i] += mat[j - 1] * mat[i - j];
        
        return mat[n];
        
    }
}
