public class Solution {
    public int climbStairs(int n) {
        int prev2, prev1, curr = 1;
        
        if(n <= 1)
            return curr;
        
        prev2 = prev1 = 1;
        for(int i = 2; i <= n; i++){
            curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return curr;
    }
}
