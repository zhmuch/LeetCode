import java.util.*;

public class Solution {
    public int maximalSquare(char[][] matrix) {

        int row = matrix.length;
        if(row == 0)
            return 0;
        int col = matrix[0].length;

        int max = 0;

        int[][] mat = new int[row][col];

        for(int i = 0; i < row; i++)
            if(matrix[i][0] == '1'){
                mat[i][0] = 1;
                max = 1;
            }

        for(int j = 0; j < col; j++)
            if(matrix[0][j] == '1'){
                mat[0][j] = 1;
                max = 1;
            }

        System.out.println(max);

        for(int i = 1; i < row; i++)
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == '0')
                    mat[i][j] = 0;
                else{
                    mat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]) + 1;
                    max = Math.max(max, mat[i][j]);
                }
            }

        return max * max;

    }
}
