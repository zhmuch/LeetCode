public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i,bin=0;
        for (i = 0; i < 32; i++)
            bin+=(n >> i & 1)<<(31-i);
        return bin;
    }
}


//  Simple,
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
         return Integer.reverse(n);
    }
}
