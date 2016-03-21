/*
  Use String Buffer instead of String.
*/
public class Solution {
    public String countAndSay(int n) {
        if(n < 1)
            return "";

        String res = "1";

        for(int i=1; i<n; i++){
            StringBuffer buffer = new StringBuffer();
            for(int j=0; j<res.length(); ){
                int count = 1;
                while( j + count < res.length() && res.charAt(j + count) == res.charAt(j) )
                    count++;
                buffer.append(count);
                buffer.append(res.charAt(j));
                j += count;
            }
            res = buffer.toString();
        }

        return res;
    }
}

/*
  Straightforward.
*/

public class Solution {
    public String countAndSay(int n) {
        if(n < 1)
            return "";

        String res = "1";
        for(int i=1; i<n; i++){

            String tmp = "";
            for(int j=0; j<res.length(); ){
                int count = 1;
                while( j + count < res.length() && res.charAt(j + count) == res.charAt(j) )
                    count++;
                tmp = tmp + count + res.charAt(j);
                j += count;
            }
            res = tmp;
        }

        return res;
    }
}
