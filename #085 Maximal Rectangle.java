public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row==0) return 0;
        int col = matrix[0].length;

        int[][] sta = new int[row][col];
        for(int i=0; i<col; i++){
            if (matrix[row-1][i] == '1') sta[row-1][i] = 1;
            else sta[row-1][i] = 0;
        }
        for(int i=row-2; i>=0; i--){
            for(int j=0; j<col; j++){
                if (matrix[i][j] == '1') sta[i][j] = sta[i+1][j] + 1;
                else sta[i][j] = 0;

            }
        }

        int max = 0;
        for(int i=0; i<row; i++){
            max = Math.max(largestRectangleArea(sta[i]), max);
        }
        return max;
    }

    public int largestRectangleArea(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int max = arr[0];

        for(int i=1; i<nums.length; i++){
            arr[i] = nums[i];
            for(int j=i-1; j>=0; j--){
                if(arr[j]>arr[i]){
                    max = Math.max(arr[j]*(i-j), max);
                    arr[j] = arr[i];
                }
                else break;
            }
        }

        for(int i=0; i<nums.length; i++){
            max = Math.max((nums.length-i)*arr[i], max);
        }

        return max;
    }
}
