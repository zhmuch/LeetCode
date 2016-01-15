/*
  Straight. Wait to be improved.
*/

public class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        if(row==0) return;
        int col = board[0].length;
        int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int live = 0;
                for(int k=0; k<8; k++){
                    if((i+direction[k][0])>=0 && (i+direction[k][0])<row && (j+direction[k][1]>=0) && (j+direction[k][1])<col) {
                        int temp = board[i+direction[k][0]][j+direction[k][1]];
                        if(temp==1 || temp ==4) live++;
                    }
                }
                if (board[i][j]==0){
                    if (live==3) board[i][j] = 3;
                }
                else{
                    if(live<2 || live>3) board[i][j] = 4;
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 3) board[i][j] = 1;
                if(board[i][j] == 4) board[i][j] = 0;
            }
        }
    }
}
