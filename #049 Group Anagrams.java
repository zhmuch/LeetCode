/*
  Time Limit Exceed.
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int l = strs.length;

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int l = o1.length();
                for(int i=0; i<l; l++){
                    if(o1.charAt(i) == o2.charAt(i)) continue;
                    else if(o1.charAt(i) > o2.charAt(i)) return 1;
                    else return -1;
                }
                return 0;
            }
        };

        Hashtable<String, Integer> hash = new Hashtable<>();
        int index = 0;
        for(int i=0; i<l; i++){
            String simp = simp(strs[i]);
            if (hash.containsKey(simp)){
                int ind = hash.get(simp);
                res.get(ind).add(strs[i]);
            }
            else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                res.add(temp);
                hash.put(simp, index);
                index++;
            }
        }
        for(int i=0; i<index; i++){
            Collections.sort(res.get(i), comparator);
        }
        return res;
    }

    public String simp(String a) {
        int[] temp = new int[a.length()];
        for(int i=0; i<a.length(); i++){
            temp[i] = a.charAt(i);
        }
        Arrays.sort(temp);
        String res = new String();
        for(int i=0; i<a.length(); i++){
            res = res + (char)temp[i];
        }
        return res;
    }
}
