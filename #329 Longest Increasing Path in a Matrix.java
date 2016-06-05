//  Other`s improvment;
//  可以直接使用cache[][]来记录已经遍历过的长度
//  不用担心造成loop，因为满足longestIncreasing条件，不会产生loop

import java.util.*;

public class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length<=0 || matrix[0].length <=0) 
            return 0;
        
        int max=0, n = matrix.length, m = matrix[0].length;
        
        int[][] cache = new int[n][m];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, maxLen(matrix, Integer.MIN_VALUE, i, j, cache));
            }
        }
        
        return max;
    }
    
    public int maxLen(int[][] matrix, int min, int r, int c, int[][] cache) {
        if(r<0 || c<0 || r>=matrix.length || c>= matrix[0].length) 
            return 0;
        
        if(matrix[r][c] <= min) 
            return 0;
        
        if(cache[r][c] != 0) 
            return cache[r][c];
        
        min = matrix[r][c];
        
        int up = maxLen(matrix, min, r-1, c, cache) + 1;
        int left = maxLen(matrix, min, r, c-1, cache) + 1;
        int right = maxLen(matrix, min, r, c+1, cache) + 1;
        int down = maxLen(matrix, min, r+1, c, cache) + 1;
        cache[r][c] = Math.max(up, Math.max(left, Math.max(right, down)));
        
        return cache[r][c];
    }
}




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
