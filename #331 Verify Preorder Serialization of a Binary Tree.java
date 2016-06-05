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
