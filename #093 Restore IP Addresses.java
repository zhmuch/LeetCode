/*
  Be careful with corner cases.
  And Bound Pointer.
*/

import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new LinkedList<>();

        for(int i=0; i<3; i++) {

            if(i > len - 1 || (s.charAt(0) == '0' && i != 0))
                continue;
            int i1 = Integer.parseInt(s.substring(0, i + 1));
            if (i1 > 255)
                continue;

            for (int j = i + 1; j < i + 4; j++) {

                if(j > len - 1 || (s.charAt(i + 1) == '0' && j != i+1))
                    continue;
                int i2 = Integer.parseInt(s.substring(i + 1, j + 1));
                if (i2 > 255)
                    continue;

                for (int k = j + 1; k < j + 4; k++) {

                    if (len - k > 4 || k >= len - 1)
                        continue;
                    if(s.charAt(j + 1) == '0' && k != j + 1)
                        continue;
                    if(s.charAt(k + 1) == '0' && k != len - 2)
                        continue;

                    int i3 = Integer.parseInt(s.substring(j + 1, k + 1));
                    int i4 = Integer.parseInt(s.substring(k + 1, len));

                    if (i3 > 255 || i4 > 255)
                        continue;

                    String pos = "" + i1 + '.' + i2 + '.' + i3 + '.' + i4;
                    res.add(pos);
                }
            }
        }
        return res;
    }
}
