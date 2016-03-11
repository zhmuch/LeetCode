/*
  Despicable
*/

public class Solution {
    public String intToRoman(int num) {
        String[][] roman = {  
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},  
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},  
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},  
            {"", "M", "MM", "MMM"}  
        };
        
        String res = "";
        int i = 0;
        while(num != 0){
            int j = num % 10;
            res = roman[i][j] + res;
            num = num / 10;
            i++;
        }
        
        return res;
    }
}
