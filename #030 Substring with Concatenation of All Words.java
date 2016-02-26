/*
  Other`s GOOD!
*/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(words.length==0||words[0].length()==0) return res;
        Map<String,Integer> wordDict = new HashMap<String,Integer>();
        for(String word : words) {
            if(!wordDict.containsKey(word)) wordDict.put(word,1);
            else wordDict.put(word,wordDict.get(word) + 1);
        }
        Map<String,Integer> currWords = new HashMap<String,Integer>();
        int len = words[0].length();
        for(int i = 0; i < len; i++) {
            int k = i, j = i; //k is at the head of the window and j is the last.
            int addedCount = 0; //to indicate whether we add index to res.
            while(k<= s.length()-len*words.length&&j + len <= s.length()) { //make sure the remaining length is enough.
                String subWord = s.substring(j,j+len);
                if(!wordDict.containsKey(subWord)) { //the substring is not in words, head jumps to the right of this substring.
                    addedCount = 0;
                    currWords.clear();
                    j += len;
                    k = j;
                    continue;
                }
                if(!currWords.containsKey(subWord)||currWords.get(subWord)!=wordDict.get(subWord)) {
                    if(!currWords.containsKey(subWord)) currWords.put(subWord,1);
                    else currWords.put(subWord,currWords.get(subWord) + 1); //update the current words we used.
                    addedCount++;
                    if(addedCount == words.length) { //if get a index, add it to res. And we need to continue checking
                        res.add(k);
                        addedCount--; //remove the head and check new substring, so count-- and move head to new position.
                        String preHead = s.substring(k,k+len);
                        if(currWords.get(preHead)==1) currWords.remove(preHead); //update the currWords map.
                        else currWords.put(preHead,currWords.get(preHead)-1);
                        k += len;
                    }
                    j += len;
                }
                else { //the current substring was used out before. Move head len steps right.
                    String preHead = s.substring(k,k+len);
                    addedCount--;
                    if(currWords.get(preHead)==1) currWords.remove(preHead); //update the currWords map.
                    else currWords.put(preHead,currWords.get(preHead)-1);
                    k += len; //don't move j this case.
                }
            }
            currWords.clear();
        }
        return res;
    }
}



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
