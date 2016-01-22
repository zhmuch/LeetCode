import java.util.*;

public class Solution {
    Hashtable[] row = new Hashtable[9];
    Hashtable[] col = new Hashtable[9];
    Hashtable[][] cube = new Hashtable[3][3];
    

    public void solveSudoku(char[][] board) {
        if(board.length!=9 || board.length!=board[0].length) return;
        
        for(int i=0; i<9; i++){
            row[i] = new Hashtable();
            col[i] = new Hashtable();
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                cube[i][j] = new Hashtable();
            }
        }
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char temp=board[i][j];
                if(temp=='.') continue;
                row[i].put(j, temp);
                col[j].put(i, temp);
                cube[i/3][j/3].put(i*10+j, temp);
            }
        }
        int i=0, j=0;
        while(i!=9 && board[i][j]!='.'){
            j++;
            if(j>8) {
                j=0;
                i++;
            }
        }
        if(i==9) return;
        // char temp = (char)(1+'0');
        else search(board, i, j);
    }

    public boolean search(char[][] board, int r, int c){
        if(board[r][c]!='.'){
            if(r==8 && c==8) return true;
            c++;
            if(c>8){
                c=0;
                r++;
            }
            return search(board, r, c);
        }
        else{
            for(int i=0; i<9; i++){
                char temp = (char)(i+'1');
                if(!row[r].contains(temp) && !col[c].contains(temp) && !cube[r/3][c/3].contains(temp)){
                    board[r][c] = temp;
                    row[r].put(c, temp);
                    col[c].put(r, temp);
                    cube[r/3][c/3].put(r*10+c, temp);
    
                    if(r==8 && c==8) return true;
    
                    int cc=c+1;
                    int rr=r;
                    if(cc>8) {
                        cc=0;
                        rr++;
                    }
                    if(search(board, rr, cc)){
                        return true;
                    }
                    else{
                        board[r][c] = '.';
                        row[r].remove(c);
                        col[c].remove(r);
                        cube[r/3][c/3].remove(r*10+c);
                    }
                }
            }
            return false;
        }
    }
}
