//  Same as #130;

public class Solution {
    char[][] grid;
    int row, col;

    public int numIslands(char[][] grid) {
        if(grid == null)
            return 0;
        this.row = grid.length;
        if(row <= 0)
            return 0;
        this.col = grid[0].length;
        if(col <= 0)
            return 0;

        this.grid = grid;
        int count = 0;
        
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                if(grid[i][j] == '1'){
                    grid[i][j] = 'X';
                    count++;
                    BFS(i, j);
                }
        
        return count;
    }

    private void BFS(int r, int c) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[] n = {r, c};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int i = 0; i < 4; i++){
                int tr = curr[0] + directions[i][0];
                int tc = curr[1] + directions[i][1];
                if(tr >= 0 && tr < row && tc >= 0 && tc < col){
                    if(grid[tr][tc] == '1'){
                        grid[tr][tc] = 'X';
                        int[] tmp = {tr, tc};
                        queue.add(tmp);
                    }
                }
            }
        }

        return;
    }
}
