/*
  Waited to be optimized.
*/

public class Solution {
    public String minWindow(String s, String t) {
        String res = new String();
        int ls = s.length();
        int lt = t.length();
        int left = 0, right = 0;
        int l = 0, r = 0;
        int min = ls + 100;

        Hashtable<Character, Integer> table = new Hashtable<>();
        Hashtable<Character, Integer> form = new Hashtable<>();
        for(int i=0; i<lt; i++){
            char temp = t.charAt(i);
            int num = 0;
            if(table.containsKey(temp)) num = table.get(temp);
            table.put(temp, num+1);
            form.put(temp, 0);
        }

        boolean match = false;
        int unMatch = lt;

        while(right != ls && left <= right){
            if(match){
                if((right - left) < min){
                    l = left;
                    r = right;
                    min = right - left;
                }

                char temp = s.charAt(left);
                if(table.containsKey(temp)){
                    if(form.get(temp) > table.get(temp)){
                        left++;
                        form.put(temp, form.get(temp)-1);
                    }
                    else {
                        right++;
                        if(right < ls && table.containsKey(s.charAt(right))){
                            form.put(s.charAt(right), form.get(s.charAt(right))+1);
                        }
                    }
                }
                else left++;
            }
            else {
                char temp = s.charAt(right);
                if(form.containsKey(temp)){
                    int num = form.get(temp);
                    if(num < table.get(temp)){
                        unMatch--;
                    }
                    form.put(temp, num+1);
                }
                if(unMatch == 0) match = true;
                else right++;
            }

        }

        if(match){
            for(int i=l; i<=r; i++){
                res = res + s.charAt(i);
            }
        }

        return res;
    }
}
