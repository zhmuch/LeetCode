//  Time Limit Exceeds...

public class Solution {

//    boolean[][] isSearched;
    int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null)
            return 0;
        int row = matrix.length;
        if(row < 1)
            return 0;
        int col = matrix[0].length;
        if(col < 1)
            return 0;

//        isSearched = new boolean[row][col];
        
        int res = 1;
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++){
                boolean asStart = true;
                for(int k = 0; k < 4; k++){
                    int tmpR = i + directions[k][0];
                    int tmpC = j + directions[k][1];
                    if(tmpR >= 0 && tmpR < row && tmpC >= 0 && tmpC < col){
                        if(matrix[tmpR][tmpC] < matrix[i][j]){
                            asStart = false;
                            break;
                        }
                    }
                }
                if(asStart){
                    boolean[][] isVisited = new boolean[row][col];
                    isVisited[i][j] = true;
                    res = Math.max(res, dfs(i, j, matrix, isVisited));
                }
            }
        
        return res;

    }

    private int dfs(int r, int c, int[][] matrix, boolean[][] isVisited){
        
        int res = 0;

        for(int k = 0; k < 4; k++){
            int tmpR = r + directions[k][0];
            int tmpC = c + directions[k][1];
            if(tmpR >= 0 && tmpR < matrix.length && tmpC >= 0 && tmpC < matrix[0].length 
                    && !isVisited[tmpR][tmpC] && matrix[tmpR][tmpC] > matrix[r][c]){
                isVisited[tmpR][tmpC] = true;
                res = Math.max(res, dfs(tmpR, tmpC, matrix, isVisited));
                isVisited[tmpR][tmpC] = false;
            }
        }
        
        return res + 1;
    }
}
