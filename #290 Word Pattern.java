public class Solution {
    public boolean wordPattern(String pattern, String str) {
        int pLen = pattern.length();
        int sLen = 0;
        if(pLen==0) return false;
        int l = str.length();

        Hashtable p = new Hashtable();
        String temp="";
        for(int i=0; i<l; i++){
            char t = str.charAt(i);
            if(t==' '){
                if(p.containsKey(pattern.charAt(sLen))){
                    if(!p.get(pattern.charAt(sLen)).equals(temp)) return false;
                }
                else{
                    if(p.contains(temp)) return false;
                }
                p.put(pattern.charAt(sLen), temp);
                sLen++;
                if(sLen==pLen) return false;
                temp="";
            }
            else {
                temp = temp + t;
            }
        }



        if(p.containsKey(pattern.charAt(sLen))){
            if(!p.get(pattern.charAt(sLen)).equals(temp)) return false;
        }
        else{
            if(p.contains(temp)) return false;
        }
        p.put(pattern.charAt(sLen), temp);
        sLen++;
        if(pLen!=sLen) return false;

        return true;
    }
}
