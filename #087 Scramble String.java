/*
  Other`s
*/

public class Solution {  
    public boolean isScramble(String s1, String s2) {  
        if(s1.equals(s2)) return true;  
          
        if(!hasSameChars(s1, s2)) return false;  
          
        for(int i=0; i<s1.length()-1; i++) {  
            if( isScramble(s1.substring(0, i+1), s2.substring(0, i+1)) && isScramble(s1.substring(i+1), s2.substring(i+1)) )  
                return true;  
            if( isScramble(s1.substring(0, i+1), s2.substring(s1.length()-1-i)) && isScramble(s1.substring(i+1), s2.substring(0, s1.length()-1-i)) )                   
                return true;  
        }  
        return false;  
    }  
      
    private boolean hasSameChars(String s1, String s2) {  
        if(s1.length() != s2.length()) return false;  
          
        int[] bitmap = new int[26];  
        for(int i=0; i<s1.length(); i++) {  
            bitmap[s1.charAt(i)-'a']++;  
            bitmap[s2.charAt(i)-'a']--;  
        }  
          
        for(int i=0; i<26; i++) {  
            if(bitmap[i]!=0) return false;  
        }  
        return true;  
    }  
}  

/*
  Evenly Participation.
  Not Correct.
*/

public class Solution {
    public boolean isScramble(String s1, String s2) {

//        System.out.println("s1: " + s1);
//        System.out.println("s2: " + s2);

        if(s1.equals(s2)) return true;

        if(!hasSameChars(s1, s2)) return false;

        int l = s1.length();

        String s1l = s1.substring(0, l/2), s1r = s1.substring(l/2, l);
        String s2l = s2.substring(0, l/2), s2r = s2.substring(l/2, l);
        String s2rl, s2rr;
        if(l % 2 != 0){
            s2rl = s2.substring(l/2+1, l); 
            s2rr = s2.substring(0, l/2+1);
        }
        else{
            s2rl = s2.substring(l/2, l);
            s2rr = s2.substring(0, l/2);
        }

//        System.out.println("s1l: " + s1l + "  s1r: " + s1r);
//        System.out.println("s2l: " + s2l + "  s2r: " + s2r);
//        System.out.println("s2rl: " + s2rl + "  s2rr: " + s2rr);
//
//        System.out.println("=========");

        if(hasSameChars(s1l, s2l))
            return (isScramble(s1l, s2l) && isScramble(s1r, s2r));

        if(hasSameChars(s1l, s2rl))
            return (isScramble(s1l, s2rl) && isScramble(s1r, s2rr));

        return false;
    }
    private boolean hasSameChars(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int[] bitmap = new int[26];
        for(int i=0; i<s1.length(); i++) {
            bitmap[s1.charAt(i)-'a']++;
            bitmap[s2.charAt(i)-'a']--;
        }

        for(int i=0; i<26; i++) {
            if(bitmap[i]!=0) return false;
        }
        return true;
    }
}
