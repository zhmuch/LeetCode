/*
  Inefficient
*/

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        
        int l2 = num2.length();

        String res = "";

        for(int i=l2-1; i>=0; i--) {
            String tmp = multi(num1, num2.charAt(i), l2-1-i);
            res = add(res, tmp);
        }

        return res;

    }

    public String multi(String num1, char t, int l) {

        String res = "";
        for(int i=0; i<l; i++)
            res = 0 + res;

        int carry = 0;

        for(int i=num1.length()-1; i>=0; i--) {
            int tmp = (num1.charAt(i) - '0') * (t - '0') + carry;
            res = (tmp % 10) + res;
            carry = tmp / 10;
        }

        if(carry != 0)
            res = carry + res;
        return res;

    }

    public String add(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 > l2)
            for(int i=0; i<(l1 - l2); i++)
                s2 = 0 + s2;
        else
            for(int i=0; i<(l2 - l1); i++)
                s1 = 0 + s1;

        String res = "";
        int l = s1.length();
        int carry = 0;

        for(int i=l-1; i>=0; i--){
            int tmp = (s1.charAt(i) - '0') + (s2.charAt(i) - '0') + carry;
            res = (tmp % 10) + res;
            carry = tmp / 10;
        }

        if(carry != 0)
            res = carry + res;

        return res;
    }
}
