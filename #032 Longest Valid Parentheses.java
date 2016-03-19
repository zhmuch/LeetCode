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
