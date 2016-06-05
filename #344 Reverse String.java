public class Solution {
    public String reverseString(String s) {
        if(s == null)
            return s;

        StringBuilder tmp = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--)
            tmp.append(s.charAt(i));

        return tmp.toString();
    }
}

//
//


public class Solution {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
