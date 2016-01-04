public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m==0) return false;
        int n = matrix[0].length;
        if (matrix[0][0]>target || matrix[m-1][n-1]<target) return false;

        int left = 0, right = m-1;
        int row;
        if (matrix[right][0]<=target) row = right;
        else{
            while(right-left>1){
                int mid = (right + left) / 2;
                if (matrix[mid][0]>target) right = mid;
                else if (matrix[mid][0]<target) left = mid;
                else return true;
            }
            row = left;
        }
        left = 0;
        right = n - 1;
        while(right-left>1){
            int mid = (right + left) / 2;
            if (matrix[row][mid]>target) right = mid;
            else if (matrix[row][mid]<target) left = mid;
            else return true;
        }
        if (matrix[row][left]==target || matrix[row][right]==target) return true;
        else return false;
    }
}
