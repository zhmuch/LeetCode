/*
  Think in reverse order!
*/

public class Solution {
    public int romanToInt(String s) {

        int res = 0;
        int max = 1;
        int l = s.length();
        
        for(int i = l-1; i >= 0; i--){
            int tmp = single(s.charAt(i));
            
            if(tmp >= max) {
                res += tmp;
                max = tmp;
            }
            else
                res -= tmp;
        }
        
        return res;
    }

    public int single(char t) {
        switch (t){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
