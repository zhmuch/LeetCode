public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();

        int row = matrix.length;
        if (row < 1) return result;
        int col = matrix[0].length;
        if (col < 1) return result;

        boolean[][] flag = new boolean[row][col];
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                flag[i][j] = true;
            }
        }

        int i = 0;
        int j = 0;
        int count = 0;
        int direction = 0;

        while (count < row * col){
            switch (direction)
            {
                case 0: {
                    while(j<col && flag[i][j]){
                        result.add(matrix[i][j]);
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
                    while(i<row && flag[i][j]){
                        result.add(matrix[i][j]);
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
                        result.add(matrix[i][j]);
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
                        result.add(matrix[i][j]);
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
