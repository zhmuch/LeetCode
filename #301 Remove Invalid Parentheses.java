//  Other`s;
//  Bloody fast!!!!!

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, res, 0, 0, new char[]{'(',')'});
        return res;
    }
    public void dfs(String s,List<String> res, int starti, int startj, char[] par){
        char[] ar = s.toCharArray();
        for(int num = 0, i = starti; i < ar.length; ++i){
            if(ar[i] == par[0])++num;
            if(ar[i] == par[1])--num;
            if(num >= 0)continue;
            for(int j = startj; j <= i; ++j)
                if(ar[j] == par[1] && (j == startj || ar[j - 1] != par[1]))
                    dfs(s.substring(0, j) + s.substring(j + 1, ar.length), res, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(par[0] == '(')
            dfs(reversed,res, 0, 0, new char[] {')','('});
        else
            res.add(reversed);
    }
}



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
