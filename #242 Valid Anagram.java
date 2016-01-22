/*
  排序，然后比较string.
*/
 
public class Solution {     
    public boolean isAnagram(String s, String t) {
        int l=s.length();
        if(l!=t.length()) return false;
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return String.valueOf(sArr).equals(String.valueOf(tArr));
    }
}  
