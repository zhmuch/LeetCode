/*
  Big Triangle DP Matrix.
*/

public class Solution {
    public int maxCoins(int[] nums) {

        int[] n = new int[nums.length + 2];
        for(int i = 1; i <= nums.length; i++)
            n[i] = nums[i - 1];
        n[0] = n[nums.length + 1] = 1;

        int[][] m = new int[n.length][n.length];

        for(int gap = 2; gap < n.length; gap++)
            for(int left = 0; left < n.length - gap; left++){
                int right = left + gap;
                for(int i = left + 1; i < right; i++)
                    m[left][right] = Math.max(m[left][right], n[left] * n[i] * n[right] + m[left][i] + m[i][right]);
            }
        
        return m[0][n.length - 1];
    }
}
