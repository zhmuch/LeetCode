/*
  Backtracking.
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();

        String tmp = "";
        generate(res, tmp, n, n);

        return res;
    }

    void generate(List<String> res, String tmp, int left, int right){
        if(left + right == 0){
            res.add(new String(tmp));
            return;
        }

        if(left == right){
            tmp = tmp + "(";
            left--;
            generate(res, tmp, left, right);
        }
        else{
            if(left > 0){
                tmp = tmp + "(";
                left--;
                generate(res, tmp, left, right);
                tmp = tmp.substring(0, tmp.length()-1);
                left++;
            }

            tmp = tmp + ")";
            right--;
            generate(res, tmp, left, right);
        }

        return;
    }
}
