import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        int l = s.length();
        if(l % 2 != 0)
            return false;
        
        Stack<Character> tmp = new Stack<>();
        for(int i=0; i<l; i++){
            char t = s.charAt(i);
            if(t == '(' || t == '[' || t == '{')
                tmp.push(t);
            else {
                if(tmp.empty())
                    return false;
                
                switch (t) 
                {
                case ')':
                    if (tmp.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (tmp.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (tmp.pop() != '{')
                        return false;
                    break;
                }
            }
        }
        
        if(tmp.empty())
            return true;
        else
            return false;
    }
}
