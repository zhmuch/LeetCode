import java.util.*;

/*
  Straight.
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int l = s.length();
        List<String> result = new LinkedList<>();
        Hashtable<String, Integer> temp = new Hashtable();
        if(l<10) return result;

        for(int i=0; i<l-9; i++){
            String tmp = "";
            for(int j=i; j<i+10; j++){
                tmp = tmp + s.charAt(j);
            }
            if(temp.containsKey(tmp)){
                if(temp.get(tmp)==0) {
                    result.add(tmp);
                    temp.replace(tmp, 0, 1);
                }
            }
            else{
                temp.put(tmp, 0);
            }
        }
        return result;
    }
}
