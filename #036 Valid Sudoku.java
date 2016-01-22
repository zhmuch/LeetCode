import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length!=9 || board[0].length!=9) return false;

        for(int i=0; i<9; i++){
            Hashtable row = new Hashtable();
            Hashtable col = new Hashtable();

            for(int j=0; j<9; j++){
                char temp=board[i][j];
                if(temp!='.'){
                    if(row.contains(temp)) return false;
                    row.put(j,temp);
                }

                char ttemp=board[j][i];
                if(ttemp!='.'){
                    if(col.contains(ttemp)) return false;
                    col.put(j,ttemp);
                }
            }
        }

        for(int ii=0; ii<3; ii++){
            for(int jj=0; jj<3; jj++){

                Hashtable cube = new Hashtable();
                for(int i=ii*3; i<ii*3+3; i++){
                    for(int j=jj*3; j<jj*3+3; j++){
                        char temp=board[i][j];
                        if(temp!='.'){
                            if(cube.contains(temp)) return false;
                            cube.put(i*10+j,temp);
                        }
                    }
                }
                
            }
        }
        
        return true;
    }
}
