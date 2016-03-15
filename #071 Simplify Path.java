/*
  Lack of classification.
*/

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
//            System.out.println("index: " + index);
//            System.out.println("index: " + path.charAt(index));
            tmp = tmp + path.charAt(index);
//            System.out.println("tmp: " + tmp);
            index++;
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

        String res = "";
        while(!stack.empty())
            res = stack.pop() + res;

        return res;
    }
}
