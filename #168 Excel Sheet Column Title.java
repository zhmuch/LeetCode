public class Solution {
    public String convertToTitle(int n) {
        if(n < 1)
            return null;
            
        String res = "";
        while(n != 0){
            if(n % 26 == 0){
                n -= 26;
                res = 'Z' + res;
            }
            else
                res = (char)('A' + ((n % 26) - 1)) + res;
            n /= 26;
        }
        
        return res;
    }
}
