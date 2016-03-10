public class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0)
            return false;
  
        int div = 1;
        while (x / div >= 10) {
             div *= 10;
         }
  
        int left = 0;
        int right = 0;
        while (x != 0) {
             left = x / div;
             right = x % 10;
  
             if (left != right)
                 return false;
  
             x = (x % div) / 10;
             div /= 100;
         }
  
         return true;
    }
}
