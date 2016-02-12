/*
  Two pointers.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<2) return n;

        int left = 0, right = 0;
        int max = 0, l = 0;

        HashSet temp = new HashSet();
        
        while(right<n){
            char t = s.charAt(right);
            if (!temp.contains(t)){
                l++;
                temp.add(t);
            }
            else{
                max = Math.max(max, l);
                while(s.charAt(left)!=t){
                    temp.remove(s.charAt(left));
                    left++;
                    l--;
                }
                left++;
            }
            right ++;
        }
        max = Math.max(max, l);
        return max;
    }
}
