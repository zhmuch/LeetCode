public class Solution {
    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        
        if(la > lb)
            for(int i = 0; i < la - lb; i++)
                b = '0' + b;
        else
            for(int i = 0; i < lb - la; i++)
                a = '0' + a;
                
        int l = a.length();
        String res = "";
        int carry = 0;
        for(int i = l - 1; i >= 0; i--){
            int tmp = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            res = (tmp % 2) + res;
            carry = tmp / 2;
        }
        if(carry != 0)
            res = '1' + res;
        
        return res;
    }
}
