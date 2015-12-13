/*
	DFS
	未优化
*/

public class Solution {
    public boolean exist(char[][] board, String word){
        if(word.length()==0) {  
        	return false;  
    	}  

        int i,j;
        boolean[][] flag = new boolean[board.length][board[0].length];
        
        for (i=0; i<board.length; i++) {
        	for (j=0; j<board[i].length; j++) {
        		flag[i][j] = true;
        	}
        }

        for (i=0; i<board.length; i++) {
        	for (j=0; j<board[i].length; j++) {
        		if (board[i][j] == word.charAt(0)) {
        			flag[i][j] = false;
        			int idx = 1;
        			if (idx == word.length() || search(board, word, i, j, idx, flag)) {
        			    return true;
        			}
        			flag[i][j] = true;
        		}
        	}
        }

        return false;
    }


    boolean search(char[][] board, String word, int i, int j, int idx, boolean[][] flag){
    	int[][] move = {{0,1}, {-1,0}, {0,-1}, {1,0}};

    	if (idx == word.length()) {
    		return true;
    	}
    	else {
    		for (int m=0; m<4; m++) {
    			int mi = i + move[m][0];
    			int mj = j + move[m][1];
    			if (mi>=0 && mi<board.length && mj>=0 && mj<board[mi].length && board[mi][mj]==word.charAt(idx) && flag[mi][mj]==true){
    				flag[mi][mj] = false;
    				idx ++;
    				if (search (board, word, mi, mj, idx, flag)) {
    					return true;
    				}
    				flag[mi][mj] = true;
    				idx --;	
    			}
    		}
    	return false;
    	}
    }
}
