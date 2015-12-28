/*
  Modified from #054 Spiral Matrix.
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        if (n<1) {
            int[][] result = new int[0][0];
            return result;
        }

        int[][] result = new int[n][n];

        boolean[][] flag = new boolean[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                flag[i][j] = true;
            }
        }

        int i = 0;
        int j = 0;
        int count = 1;
        int direction = 0;

        while (count <= n * n){
            switch (direction)
            {
                case 0: {
                    while(j<n && flag[i][j]){
                        result[i][j] = count;
                        count++;
                        flag[i][j]=false;
                        j++;
                    }
                    j--;
                    i++;
                    direction = 1;
                    break;
                }
                case 1: {
                    while(i<n && flag[i][j]){
                        result[i][j] = count;
                        count++;
                        flag[i][j]=false;
                        i++;
                    }
                    i--;
                    j--;
                    direction = 2;
                    break;
                }
                case 2: {
                    while(j>=0 && flag[i][j]){
                        result[i][j] = count;
                        count++;
                        flag[i][j]=false;
                        j--;
                    }
                    j++;
                    i--;
                    direction = 3;
                    break;
                }
                case 3: {
                    while(i>=0 && flag[i][j]){
                        result[i][j] = count;
                        count++;
                        flag[i][j]=false;
                        i--;
                    }
                    i++;
                    j++;
                    direction = 0;
                    break;
                }
            }

        }
        return result;
    }
}
