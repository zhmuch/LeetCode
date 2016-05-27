//  求 m 与 n 二进制编码中 同为1的前缀
//  按位比较，不一样就跳出。

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int bit = 0;  
        while(m != n) {  
            m >>= 1;  
            n >>= 1;  
            bit++;  
        }  
        return m << bit;  
    }
}

//  Simple, Time Limit Exceeds...
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int start = m;
        for(int i = m + 1; i <= n; i++)
            start = start & i;
        return start;
    }
}
