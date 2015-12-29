public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0 ) return;
        int col = matrix[0].length;
        if (col == 0 ) return;

        boolean[] rowflag = new boolean[row];
        for(int i=0; i<row; i++) rowflag[i] = false;
        boolean[] colflag = new boolean[col];
        for(int i=0; i<col; i++) colflag[i] = false;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    rowflag[i] = true;
                    colflag[j] = true;
                }
            }
        }
        int count = 0;
        int[] crow = new int[row];
        for(int i=0; i<row; i++){
            if (rowflag[i]){
                for(int j=0; j<col; j++) {
                    matrix[i][j] = 0;
                }
            }
            else {
                crow[count] = i;
                count++;
            }
        }

        for(int i=0; i<col; i++){
            if (colflag[i]){
                for(int j=0; j<count; j++){
                    matrix[crow[j]][i] = 0;
                }
            }
        }
    }
}
