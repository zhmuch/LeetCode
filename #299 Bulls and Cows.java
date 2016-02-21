import java.util.*;

public class Solution {
    public String getHint(String secret, String guess) {
        int l = secret.length();
        int bulls = 0;
        int cows = 0;
        String res = new String();

        if(l == 0) return res;

        Hashtable<Character, Integer> sec = new Hashtable<>();
        Hashtable<Character, Integer> gue = new Hashtable<>();

        for (int i=0; i<l; i++){
            char ts = secret.charAt(i);
            char tg = guess.charAt(i);
            if (ts == tg) bulls++;
            else {
                if (sec.containsKey(ts)) {
                    sec.put(ts, sec.get(ts)+1);
                }
                else{
                    sec.put(ts, 1);
                }

                if (gue.containsKey(tg)) {
                    gue.put(tg, gue.get(tg)+1);
                }
                else{
                    gue.put(tg, 1);
                }
            }
        }

        Iterator<Character> it = gue.keySet().iterator();
        while(it.hasNext()){
            char temp = it.next();
            if(sec.containsKey(temp)) {
                cows += Math.min(sec.get(temp),gue.get(temp));
            }
            else continue;
        }

        res = bulls + "A" + cows + "B";

        return res;
    }
}
