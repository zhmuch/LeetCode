
//  Simple, Time Limit Exceeds...
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int start = m;
        for(int i = m + 1; i <= n; i++)
            start = start & i;
        return start;
    }
}
