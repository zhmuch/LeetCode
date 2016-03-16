/*
  6ms
*/
public class Solution {
  public static String reverseWords(String s) {
    StringBuilder res = new StringBuilder();
    for (int start = s.length() - 1; start >= 0; start--) {
      if (s.charAt(start) == ' ') 
        continue;
      int end = start;
      while (start >= 0 && s.charAt(start) != ' ') 
        start--;
      res.append(s.substring(start + 1, end + 1)).append(" ");
    }
    return res.toString().trim();
  }
}

/*
  Built-in Library
*/
public class Solution {
  public String reverseWords(String s) {
      String[] words = s.trim().split(" +");
      Collections.reverse(Arrays.asList(words));
      return String.join(" ", words);
  }
}

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
