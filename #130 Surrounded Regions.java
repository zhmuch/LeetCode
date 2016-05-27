//  Stack Overflow;

public class Solution {
    char[][] board;
    int row, col;

    public void solve(char[][] board) {
        if(board == null)
            return;
        this.row = board.length;
        if(row <= 0)
            return;
        this.col = board[0].length;
        if(col <= 0)
            return;

        this.board = board;
        
        // System.out.println(row);
        // System.out.println(col);
        
        int i = 0, j = 0;
        for(; j < col; j++)
            if(board[i][j] == 'O'){
                board[i][j] = 'P';
                BFS(i, j);
            }
        j--;
        for(; i < row; i++)
            if(board[i][j] == 'O'){
                board[i][j] = 'P';
                BFS(i, j);
            }
        i--;
        for(; j >= 0; j--)
            if(board[i][j] == 'O'){
                board[i][j] = 'P';
                BFS(i, j);
            }
        j++;
        for(; i >= 0; i--)
            if(board[i][j] == 'O'){
                board[i][j] = 'P';
                BFS(i, j);
            }
        
        for(i = 0; i < row; i++)
            for(j = 0; j < col; j++)
                if(board[i][j] == 'P')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
        
        return;
    }

    private void BFS(int r, int c) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int i = 0; i < 4; i++){
            int tr = r + directions[i][0];
            int tc = c + directions[i][1];
            if(tr >= 0 && tr < row && tc >= 0 && tc < col){
                if(board[tr][tc] == 'O'){
                    board[tr][tc] = 'P';
                    BFS(tr, tc);
                }
            }
        }
        
        return;
    }
}
