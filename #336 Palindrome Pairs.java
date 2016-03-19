/*
  TLE
*/
import java.util.*;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int size = words.length;
        List<List<Integer>> res = new LinkedList<>();
        Hashtable<String, Integer> tab = new Hashtable<>();
//        int[] len = new int[size];

        for(int i=0; i<size; i++)
            tab.put(words[i], i);
//            len[i] = words[i].length();


        for(int i=0; i<size; i++){
            String tmp = reverse(words[i]);
            int l = tmp.length();

            if(tab.containsKey(tmp) && tab.get(tmp) != i) {
                LinkedList t = new LinkedList();
                t.add(i);
                t.add(tab.get(tmp));
                res.add(t);
            }

            for(int j=0; j<size; j++){
                if(i == j || words[i].length() <= words[j].length())
                    continue;
                else{
                    int lj = words[j].length();
                    if(tab.containsKey(tmp.substring(lj, l)) && isPal(tmp, 0, lj-1)){
                        LinkedList tt = new LinkedList();
                        tt.add(i);
                        tt.add(j);
                        res.add(tt);
                    }
                    if(tab.containsKey(tmp.substring(0, lj)) && isPal(tmp, lj, l-1)){
                        LinkedList ttt = new LinkedList();
                        ttt.add(j);
                        ttt.add(i);
                        res.add(ttt);
                    }
                }
            }
        }
        
        return res;
    }

    boolean isPal(String s, int left, int right){
        while(left < right)
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }

    String reverse(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}

/*
  Time Limit Exceeds.
*/

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int size = words.length;
        List<List<Integer>> res = new LinkedList<>();
         
        for(int i=0; i<size; i++)
            for(int j=i+1; j<size; j++){
                String tmp = words[i] + words[j];
                if(isPal(tmp)){
                    List<Integer> tmp1 = new LinkedList<>();
                    tmp1.add(i);
                    tmp1.add(j);
                    res.add(tmp1);
                }
                
                tmp = words[j] + words[i];
                if(isPal(tmp)){
                    List<Integer> tmp2 = new LinkedList<>();
                    tmp2.add(j);
                    tmp2.add(i);
                    res.add(tmp2);
                }
            }
        return res;
    }
    boolean isPal(String s) {
        int l = s.length();
        int left = 0, right = l - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
