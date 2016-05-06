//  O(nlogn),
//  Other`s Work;
public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}


//  O(n^2) complexity.

public class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = nums.length;
        if(len < 1)
            return 0;
        
        int[] mat = new int[len];
        for(int i = 0; i < len; i++)
            mat[i] = 1;
        
        int max = 1;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++)
                if(nums[i] > nums[j])
                    mat[i] = Math.max(mat[i], mat[j] + 1);
                    
            max = Math.max(max, mat[i]);
        }
    
        return max;
        
    }
}
