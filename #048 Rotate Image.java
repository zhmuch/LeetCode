public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = n / 2;
        
        for (int j=0; j<m; j++){
            for (int k=j; k<n-j-1; k++){
                int temp = matrix[j][k];
                matrix[j][k] = matrix[n-1-k][j];
                matrix[n-1-k][j] = matrix[n-1-j][n-1-k];
                matrix[n-1-j][n-1-k] = matrix[k][n-1-j];
                matrix[k][n-1-j] = temp;
            }
        }
        return;
    }
}
