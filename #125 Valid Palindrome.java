import java.util.*;

public class Solution {
    public boolean isPalindrome(String s) {
        int l = s.length();
        if(l < 1)
            return true;

        s = s.toLowerCase();

        int left = 0, right = l - 1;
        while(true){
            while(left < l && !((s.charAt(left) >= '0' && s.charAt(left) <= '9') || (s.charAt(left) >= 'a' && s.charAt(left) <= 'z')) )
                left++;
            
            while(right > -1 && !((s.charAt(right) >= '0' && s.charAt(right) <= '9') || (s.charAt(right) >= 'a' && s.charAt(right) <= 'z')) )
                right--;
            
            if(left >= right)
                return true;

            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }
    }
}
