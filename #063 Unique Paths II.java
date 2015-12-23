public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	boolean flag = true;

        int[][] v = new int [m][n];
        
        for(int i=0; i<n; i++){
        	if (!flag || obstacleGrid[0][i]==1) {
        		flag = false;
        		v[0][i] = 0;
        	}
        	else v[0][i] = 1;

        }
        flag = true;
        for(int i=0; i<m; i++){
        	if (!flag || obstacleGrid[i][0]==1) {
        		flag = false;
        		v[i][0] = 0;
        	}
        	else v[i][0] = 1;
        }


        for(int i=1; i<m; i++){  
            for(int j=1; j<n; j++){
            	if (obstacleGrid[i][j]==0)  
                	v[i][j]=v[i-1][j]+v[i][j-1];
                else
                	v[i][j]=0;
            }  
        }  
        return v[m-1][n-1];  
    }
}
