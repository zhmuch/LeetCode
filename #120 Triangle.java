public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() < 1) {
            return 0;
        }

        /*Constructing Array*/
        int[][] sum = new int[triangle.size()][];
        for (int i=0; i<sum.length; i++){
        	sum[i] = new int[i+1];
        }

     	/*Iterator*/
     	for (int i=0; i<sum.length; i++){
     		sum[sum.length-1][i] = triangle.get(sum.length-1).get(i);
     	}   

     	for (int i=sum.length-2; i>=0; i--){
     		for (int j=0; j<sum[i].length; j++){
     			if (sum[i+1][j] > sum[i+1][j+1]){
     				sum[i][j] = sum[i+1][j+1] + triangle.get(i).get(j);
     			}
     			else {
     				sum[i][j] = sum[i+1][j] + triangle.get(i).get(j);	
     			}
     		}

     	}

     	return sum[0][0];
    }
}
