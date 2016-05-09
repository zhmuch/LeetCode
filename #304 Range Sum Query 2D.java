/**
 * Created by Muchen on 5/9/16.
 */
public class NumMatrix {
    int row;
    int col;
    boolean flag;
    int[][] sumsRow;

    public NumMatrix(int[][] matrix) {
        this.row = matrix.length;
        this.col = (row != 0) ? matrix[0].length : 0;
        flag = (row * col != 0) ? true : false;

        sumsRow = new int[row][col + 1];
        for(int i = 0; i < row; i++){
            sumsRow[i][0] = 0;
            sumsRow[i][1] = matrix[i][0];
            for(int j = 2; j <= col; j++)
                sumsRow[i][j] = sumsRow[i][j - 1] + matrix[i][j - 1];
//            System.out.println(i + "th: " + sumsRow[i][1]);
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        if(flag){
            for(int i = row1; i <= row2; i++)
                res += sumsRow[i][col2 + 1] - sumsRow[i][col1];
        }

        return res;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
