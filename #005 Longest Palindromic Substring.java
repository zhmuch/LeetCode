/*
  Brute Search.
  Can be improved.
*/

public class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        if(l < 1)
            return "";

        int max = 1;
        int left = 0, right = 0;

        for(int p=0; p<l; p++){
            int tl = p, tr = p;
            int len = -1;
            while(tl >= 0 && tr < l && s.charAt(tl) == s.charAt(tr)) {
                tl--;
                tr++;
                len += 2;
            }
            if(len > max){
                max = len;
                left = tl + 1;
                right = tr - 1;
            }

            if(p < l-1){
                len = 0;
                tl = p;
                tr = p + 1;
                while(tl >= 0 && tr < l && s.charAt(tl) == s.charAt(tr)){
                    tl--;
                    tr++;
                    len += 2;
                }
                if(len > max){
                    max = len;
                    left = tl + 1;
                    right = tr - 1;
                }
            }
        }

        return s.substring(left, right+1);
    }
}
