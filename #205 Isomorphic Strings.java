/*
  Bidirection-Hashtable
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int l = s.length();
        if(l!=t.length()) return false;

        Hashtable<Character, Character> stable = new Hashtable<>();
        Hashtable<Character, Character> ttable = new Hashtable<>();
        for(int i=0; i<l; i++){
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if(stable.containsKey(ss)){
                if(stable.get(ss)!=tt) return false;
            }
            else{
                stable.put(ss, tt);
            }
            
            if(ttable.containsKey(tt)){
                if(ttable.get(tt)!=ss) return false;
            }
            else{
                ttable.put(tt, ss);
            }
        }
        return true;
    }
}
