/*
  DP, one Array.
*/
import java.util.*;

public class Solution {
    public int longestValidParentheses(String s) {
        int l = s.length();
        if(l < 1)
            return 0;

        int[] dp = new int[l];
        dp[0] = 0;
        int max = 0;

        for(int i=1; i<l; i++){
            if(s.charAt(i) == '(')
                dp[i] = 0;
            else{
                int p = i - 1;
                while(p >= 0 && dp[p] > 0)
                    p -= dp[p];
                if(p>=0 && s.charAt(p) == '('){
                    if(p > 0)
                        dp[i] = dp[i-1] + 2 + dp[p-1];
                    else
                        dp[i] = dp[i-1] + 2;
                    max = Math.max(dp[i], max);
                }
                else
                    dp[i] = 0;
            }
        }

        return max;
    }
}

/*
  Not continuous SubString.
*/

public class Solution {
    public int longestValidParentheses(String s) {
        int l = s.length();
        if(l < 1)
            return 0;

        int index = 0;
        int max = 0;
        int tmp = 0;

        Stack<Character> stack = new Stack<>();
        while(index < l){
            if(s.charAt(index) == '(') {
                stack.push('(');
            }
            else{
                if(stack.empty()) {
                    max = Math.max(max, tmp);
                    tmp = 0;
                }
                else{
                    stack.pop();
                    tmp += 2;
                }
            }
            index++;
        }
        max = Math.max(max, tmp);

        return max;
    }
}
