public class Solution {
    public int uniquePaths(int m, int n) {
        long mm = 1, nn = 1;
        int b;
        
        if (m > n) {
            b = n; 
        }
        else b = m;
        
        for (int i = 1; i < b; i++) {
        	nn = nn * (long) i;
        	mm = mm * (long) (m + n - 1 - i);
        }
        
        return (int) (mm / nn);
    }
}
