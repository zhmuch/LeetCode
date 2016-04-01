/*
  Small Triangle DP Matrix
*/
import java.util.*;

public class Solution {
    public int maxCoins(int[] nums) {

        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        int[][] m = new int[nums.length][nums.length];
        
        m[0][0] = nums[0] * nums[1];
        m[nums.length - 1][nums.length - 1] = nums[nums.length - 1] * nums[nums.length - 2];
        for(int i = 1; i < nums.length - 1; i++)
            m[i][i] = nums[i - 1] * nums[i] * nums[i + 1];
            
        
        for(int gap = 1; gap < nums.length; gap++)
            for(int left = 0; left < nums.length - gap; left++){
                
                int right = left + gap;
                int leftBound = (left == 0) ? 1 : nums[left - 1];
                int rightBound = (right == nums.length - 1) ? 1 : nums[right + 1];
                
                for(int i = left + 1; i < right; i++)
                    m[left][right] = Math.max(m[left][right],
                            leftBound * nums[i] * rightBound + m[left][i - 1] + m[i + 1][right]);

                m[left][right] = Math.max(m[left][right], leftBound * nums[left] * rightBound + m[left + 1][right]);
                m[left][right] = Math.max(m[left][right], leftBound * nums[right] * rightBound + m[left][right - 1]);
            }

        return m[0][nums.length - 1];
    }
}

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
