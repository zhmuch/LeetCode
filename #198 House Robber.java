import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        if(len < 1)
            return 0;
        
        int[] mat = new int[len + 1];
        mat[0] = 0;
        mat[1] = nums[0];
        
        for(int i = 2; i <= len; i++)
            mat[i] = Math.max(mat[i - 1], mat[i - 2] + nums[i - 1]);
        
        return mat[len];
        
    }
}
