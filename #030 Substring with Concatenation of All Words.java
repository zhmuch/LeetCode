/*
  Straight forward. Time exceeds.
*/

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList();
        int totalSize = words.length;
        if(totalSize <= 0) return res;
        int size = words[0].length();
        int aimSize = totalSize * size;

        Hashtable<String, Integer> wordsTable = new Hashtable<>();

        for(int i=0; i<totalSize; i++){
            int num = 0;
            if (wordsTable.containsKey(words[i]))
                num = wordsTable.get(words[i]);
            wordsTable.put(words[i], num+1);
        }

        int left = 0, right = aimSize-1;
        while(right < s.length()){
//            System.out.println("In! Left: "+left+"  Right: "+right);
            Hashtable<String, Integer> temp = new Hashtable<>();
            boolean valid = true;
            for(int i=0; i<totalSize; i++){
                String t = new String();
                for(int j=left+i*size; j<left+i*size+size; j++){
                    t = t + s.charAt(j);
                }
//                System.out.println("String t: "+t);
//                System.out.println(wordsTable.equals(temp));
                if (wordsTable.containsKey(t)){
                    int num = 0;
                    if (temp.containsKey(t))
                        num = temp.get(t);
                    temp.put(t, num+1);
                }
                else{
                    valid = false;
                    break;
                }
            }
//            System.out.println(wordsTable);
//            System.out.println(temp);
//            System.out.println(wordsTable.equals(temp));
            if(valid && wordsTable.equals(temp)){
                res.add(left);
            }
            left++;
            right++;
        }
        return res;
    }
}
