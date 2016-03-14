/*
  KMP!
*/

/*
  Naive Approach.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        int ll = haystack.length();
        int l = needle.length();
        if(l > ll)
            return -1;
        if(l == 0)
            return 0;
        
        int left = 0, right = l - 1;
        
        while(right < ll){
            boolean same = true;
            
            for(int i = left; i <= right; i++){
                if(haystack.charAt(i) != needle.charAt(i - left)){
                    same = false;
                    break;
                }
            }
            if (same)
                return left;
            left++;
            right++;
        }
        
        return -1;
    }
}
