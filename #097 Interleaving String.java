/*
  Recursive top-down. Without DP.
  Time Limit Exceeds.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l1 + l2 != l3)
            return false;

        if(l3 == 0)
            return true;

        if(l1 == 0)
            return s2.equals(s3);

        if(l2 == 0)
            return s1.equals(s3);

        if(s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)){
            return isInterleave(s1.substring(1, l1), s2, s3.substring(1, l3)) || isInterleave(s1, s2.substring(1, l2), s3.substring(1, l3));
        } else if(s1.charAt(0) == s3.charAt(0)){
            return isInterleave(s1.substring(1, l1), s2, s3.substring(1, l3));
        } else if(s2.charAt(0) == s3.charAt(0)){
            return isInterleave(s1, s2.substring(1, l2), s3.substring(1, l3));
        } else
            return false;
            
    }
}
