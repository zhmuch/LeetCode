/*
  Backtracking.
*/

public class Solution {
    String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();

        int l = digits.length();
        if(l < 1)
            return res;
        for(int i=0; i<l; i++)
            if(digits.charAt(i) > '9' || digits.charAt(i) < '2')
                return res;

        String tmp = "";
        generate(res, digits, 0, tmp);

        return res;
    }

    void generate(List<String> res, String digits, int ind, String tmp){
        if(ind == digits.length()) {
            res.add(new String(tmp));
            return;
        }

        int num = digits.charAt(ind) - '0';
        int nextInd = ind + 1;

        for(int i=0; i<dict[num].length(); i++){
            tmp = tmp + dict[num].charAt(i);
            generate(res, digits, nextInd, tmp);
            tmp = tmp.substring(0, tmp.length()-1);
        }

        return;
    }
}
