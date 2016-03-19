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
