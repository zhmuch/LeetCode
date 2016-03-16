/*
  54ms.
*/

import java.util.*;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        String[] split = s.split(" ");
        String res = "";
        for(int i=split.length-1; i>=0; i--)
            if(!split[i].equals(""))
                res = res + " " + split[i];
        res = res.trim();

        return res;
    }
}
