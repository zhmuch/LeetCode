import java.util.*;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() < 1)
            return false;

        String[] tmp = preorder.split(",");

        int leaves = 2;
        if(tmp[0].equals("#"))
            return tmp.length == 1;

        for(int i = 1; i < tmp.length; i++){

            if(tmp[i].equals("#"))
                leaves--;
            else
                leaves++;

            if(leaves <= 0 && i < tmp.length - 1)
                return false;
        }

        return leaves == 0;
    }
}


//  A little faster;

import java.util.*;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() < 1)
            return false;

        int leaves = 2;
        if(preorder.charAt(0) == '#')
            return preorder.length() == 1;

        boolean prev = false;
        
        for(int i = 1; i < preorder.length(); i++){
            char c = preorder.charAt(i);
            if(c == ','){
                prev = false;
                continue;
            }
            else if(c == '#'){
                prev = false;
                leaves--;
            }
            else if(!prev){
                leaves++;
                prev = true;
            }

            if(leaves == 0)
                return i == preorder.length() - 1;
        }

        return false;
    }
}
