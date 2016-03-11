/*
  Others` Work! Perfect
*/
public class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length(), n=num2.length(), zero=0;
        int[] a = new int[m], c = new int[m+n];
        
        for(int i=0,k=m; i<m; i++) 
          a[--k]=num1.charAt(i)-'0';
          
        for(int i=n-1; i>=0; i--)
          add(c,a,num2.charAt(i)-'0',zero++);
          
        carry(c);
        
        //Remove extra "0" at head
        int i=m+n;
        while(i>0 && c[--i]==0);
        i++;
          
        StringBuilder ret = new StringBuilder(i);
        while(i>0) 
          ret.append((char)(c[--i]+'0'));
        return ret.toString();
    }
    void carry(int[] a){
        int i;
        for(int k=0,d=0; k<a.length; k++){
            i=a[k]+d;
            a[k]=i%10;
            d=i/10;
        }
    }
    void add(int[] c, int[] a, int b, int zero){
        for(int i=zero,j=0; j<a.length; j++,i++)
            c[i]+=a[j]*b;
    }
}


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
