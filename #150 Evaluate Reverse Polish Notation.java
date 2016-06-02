import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length < 1)
            return 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            String tmp = tokens[i];
            if(isNumeric(tmp))
                stack.add(Integer.parseInt(tmp));
            else{
                int a = stack.pop();
                int b = stack.pop();

                switch (tmp) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                }
            }
        }

        return stack.pop();
    }

    private boolean isNumeric(String str){
        return (str.length() > 1) || Character.isDigit(str.charAt(0));
    }

}
