/*
  Time Limit Exceeds.
*/

public class Solution {
    public String shortestPalindrome(String s) {
        int l = s.length();

        if(l < 2)
            return s;

        int left, right;
        boolean flag = true;
        if(l % 2 == 0){
            flag = false;
            right = l / 2;
            left = right - 1;
        }
        else
            left = right = l / 2;

        while(left >= 0){
            String tmp = check(s, left, right);
            if(!tmp.equals(""))
                return tmp;

            if(flag)
                left--;
            else
                right--;

            flag = !flag;
        }
        return "ERROR!";
    }

    String check(String s, int left, int right) {
        //If succeed, return Palindrome.
        //Else return null.
//        System.out.println("IN!");

        int len = s.length();
        int l = left, r = right;
        String res = "";

        if(l == r){
            res = res + s.charAt(l);
            l--;
            r++;
        }

        while(l >= 0){
            if(s.charAt(l) == s.charAt(r)){
                res = res + s.charAt(r);
                res = s.charAt(l) + res;
                l--;
                r++;
            }
            else
                return "";
        }

        while(r < len){
            res = s.charAt(r) + res + s.charAt(r);
            r++;
        }

        return res;
    }
}
