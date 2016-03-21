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

        if(left + right == 0)
            res.add(new String(tmp));
        else if(left == right)
            generate(res, tmp + "(", left - 1, right);
        else{
            if(left > 0)
                generate(res, tmp + "(", left - 1, right);

            generate(res, tmp + ")", left, right - 1);
        }

        return;
    }
}
