import java.util.*;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row < 1)
            return false;
        int col = matrix[0].length;
        
        int i = 0, j = col - 1;
        while(i < row && j >= 0){
            if(matrix[i][j] > target)
                j--;
            else if(matrix[i][j] < target)
                i++;
            else
                return true;
        }
        return false;
    }
}
