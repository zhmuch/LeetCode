//  Unfinished;

import java.util.*;

public class Solution {

    int thr;
    LinkedList<String> res;
    String s;

    public List<String> removeInvalidParentheses(String s) {

        res = new LinkedList<>();
        this.s = s;
        
        if(s == null || s.length() < 1)
            return res;

        int count = 0;
        int leftNum = 0;
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == '(')
                leftNum++;
            else if(s.charAt(i) == ')'){
                if(leftNum == 0)
                    count++;
                else
                    leftNum--;
            }
        count += leftNum;

        thr = count;
        
        StringBuilder tmp = new StringBuilder();
        dfs(tmp, 0, 0, 0);

        return res;

    }

    private void dfs(StringBuilder tmp, int idx, int leftNum, int count){
        if(count > thr)
            return;

        if(idx >= s.length()){
            if(leftNum == 0)
                res.add(tmp.toString());
            return;
        }

        if(s.charAt(idx) == '('){
            dfs(tmp, idx + 1, leftNum, count + 1);

            tmp.append('(');
            dfs(tmp, idx + 1, leftNum + 1, count);
            tmp.deleteCharAt(tmp.length() - 1);
        } else {
            dfs(tmp, idx + 1, leftNum, count + 1);

            if(leftNum > 0){
                tmp.append(")");
                dfs(tmp, idx + 1, leftNum - 1, count);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }

    }
}
