/*
  Other`s Work
  One pass solve * and /
  Another pass solve + and -
*/
public class Solution {  
    public int calculate(String s) {  
        if(s==null || s.length()==0) return 0;  
          
        LinkedList<Integer> list = new LinkedList<Integer>();  
          
        for(int i=0; i<s.length(); i++) {  
            char c = s.charAt(i);  
            if(Character.isDigit(c)) {  
                int cur = c-'0';  
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {  
                    cur = cur * 10 + s.charAt(i+1) - '0';  
                    ++i;  
                }  
                if(!list.isEmpty() && (list.peek() == 2 || list.peek()==3)) {  
                    int op = list.pop();  
                    int opl = list.pop();  
                    int res = 0;  
                    if(op==2) res = opl * cur;  
                    else res = opl / cur;  
                    list.push(res);  
                } else {  
                    list.push(cur);  
                }                 
            } else if(c==' ') continue;  
            else {  
                switch (c) {  
                    case '+': list.push(0);  
                    break;  
                    case '-': list.push(1);  
                    break;  
                    case '*': list.push(2);  
                    break;  
                    case '/': list.push(3);  
                    break;  
                    default: return -1;  
                }  
            }  
        }  
          
        if(list.isEmpty()) return 0;  
        Collections.reverse(list);  
          
        int res = list.poll();  
          
        while(!list.isEmpty()) {  
            int op = list.poll();  
            int opr = list.poll();  
            if(op==0) res += opr;  
            else res -= opr;  
        }  
        return res;  
    }  
}  


/*
  Other`s Work 2
  Considering all possible situation
*/
public class Solution {
    public int calculate(String s) {
        int i=0;
        char op1 = 0;
        char op2 = 0;
        Integer num1 = null;
        Integer num2 = null;
        
        // num1 (op1) num2 (op2) num
        while (i<s.length()) {
            char ch = s.charAt(i);
            
            // number
            if (ch>='0' && ch<='9') {
                int j = i+1;
                while (true) {
                    if (j==s.length())
                        break;
                    
                    char chDigit = s.charAt(j);
                    if (chDigit>='0' && chDigit<='9')
                        j++;
                    else
                        break;
                }
                int num = Integer.parseInt(s.substring(i, j));
                
                if (num1==null) {
                    num1 = num;
                } else if (num2==null) {
                    if (op1=='*' || op1=='/') {
                        num1 = calc(op1, num1, num);
                        op1 = 0;
                    } else {
                        num2 = num;
                    }
                } else {
                    num2 = calc(op2, num2, num);
                    op2 = 0;
                }
                
                i = j;
                continue;
            }
            else if (ch=='*' || ch=='/') {
                if (op1==0)
                    op1 = ch;
                else
                    op2 = ch;
            } else if (ch=='+' || ch=='-') {
                if (op1==0) {
                    op1 = ch;
                } else {
                    num1 = calc(op1, num1, num2);
                    num2 = null;
                    op1 = ch;
                }
            } else {
                i++;
                continue;
            }
            
            i++;
        }
        
        if (op1!=0)
            return calc(op1, num1, num2);
        
        return num1;
    }
    
    private int calc(char op, int num1, int num2) {
        if (op=='+')
            return num1+num2;
        if (op=='-')
            return num1-num2;
        if (op=='*')
            return num1*num2;
        return num1/num2;
    }
}
