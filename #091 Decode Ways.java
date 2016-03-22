/*
  Great DP!
*/

public class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        if(l < 1)
            return 0;
        if(s.charAt(0) == '0')
            return 0;

        int[] m = new int[l + 1];
        m[0] = 1;
        m[1] = 1;

        for(int i=2; i<=l; i++){

            int curr = s.charAt(i - 1) - '0';
            m[i] = (curr == 0) ? 0 : m[i-1];

            int tmp = curr + (s.charAt(i - 2) - '0') * 10;
            if(tmp >= 10 && tmp <= 26)
                m[i] += m[i-2];

            if(m[i] == 0)
                return 0;
        }

        return m[l];
    }
}
