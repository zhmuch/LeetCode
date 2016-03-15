/*
  Other`s Work Use Split!
*/
import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        if(path==null) return null;  
          
        String[] strs = path.split("/");  
        Stack<String> stack = new Stack<String>();  
          
        for( int i=0; i<strs.length; i++) {  
            String s = strs[i];  
            if( s.equals(".") || s.length()==0) {//!alert: s.length==0 or u will have many ////.  
                 continue;  
            } else if(s.equals("..") ) {  
                if(!stack.isEmpty()){  
                    stack.pop();  
                }  
            } else {  
                stack.push(s);  
            }   
        }  
          
        StringBuilder sb = new StringBuilder();  
          
        while(!stack.isEmpty()) {  
            sb.insert(0, stack.pop() );  
            sb.insert(0, "/");  
        }  
          
        if(sb.length()==0) sb.insert(0, "/");  
        return sb.toString();  
    }
}



/*
  Lack of classification.
*/

import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        int l = path.length();
        if(l < 2)
            return path;

        if(path.charAt(l-1) != '/')
            path = path + '/';
        l = path.length();

        int index = 0;
        String tmp = "";
        Stack<String> stack = new Stack<>();

        while(true)
        {
            if(tmp.equals("")){
                tmp = tmp + path.charAt(index);
                index++;
                while(index < l && path.charAt(index) == '/')
                    index++;
                    
            }
            else
                tmp = tmp + path.charAt(index++);
                
            if(index == l)
                break;

            if(path.charAt(index) == '/'){
                if(tmp.equals("/..")){
                    if(!stack.empty())
                        stack.pop();
                }
                else if(tmp.equals("/."));
                else{
                    stack.push(new String(tmp));
                    }
                tmp = "";
            }
        }

        if(stack.empty())
            return "/";
            
        String res = "";
        while(!stack.empty())
            res = stack.pop() + res;

        return res;
    }
}
