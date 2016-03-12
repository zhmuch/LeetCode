public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        
        int l = s.length();
        int r = 1;
        
        for(int i=l-1; i>=0; i--){
            res += (s.charAt(i) - 'A' + 1) * r;
            r *= 26;
        }
        
        return res;
    }
}
