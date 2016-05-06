import java.util.*;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int row = dungeon.length;
        if(row < 1)
            return 1;
        int col = dungeon[0].length;

        //  mat[i][j] represents min HP to reach princess from (i, j);
        int[][] mat = new int[row][col];

        //  Left-Top case;
        mat[row - 1][col - 1] = Math.max(1, 1 - dungeon[row - 1][col - 1]);

        //  Last Column case;
        for(int i = row - 2; i >= 0; i--)
            mat[i][col - 1] = Math.max(1, mat[i + 1][col - 1] - dungeon[i][col - 1]);

        //  First Line case;
        for(int j = col - 2; j >= 0; j--)
            mat[row - 1][j] = Math.max(1, mat[row - 1][j + 1] - dungeon[row - 1][j]);

        //  Filling the Table;
        for(int i = row - 2; i >= 0; i--)
            for(int j = col - 2; j >= 0; j--)
                mat[i][j] = Math.max(1, Math.min(mat[i + 1][j] - dungeon[i][j], mat[i][j + 1] - dungeon[i][j]));

        return mat[0][0];

    }
}
