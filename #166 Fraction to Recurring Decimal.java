/*
  注意int size trick!!!
  int b = -2147483648.
  b = Math.abs(b);
  b仍然为 -2147483648
  
  保险做法 int 转 long
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "Infinite";
        if(numerator == 0) return "0";

        long n = numerator;
        long d = denominator;

        String a = "", b = "";
        if(n*d<0){
            a = a + "-";
            n = Math.abs(n);
            d = Math.abs(d);
        }
        long quo = n/d;
        a = a + Long.toString(quo);


        System.out.println("nume = " + numerator);
        System.out.println("deno = " + denominator);

        if(n%d != 0){
            a = a + ".";

            int index = 0;
            n = n%d;
            n = n*10;
            Hashtable<Long, Integer> nume = new Hashtable<>();

            while(!nume.containsKey(n)){
                nume.put(n, index);
                index++;

                long q = n/d;
                b = b + Long.toString(q);
                n = n%d;
                if(n==0) return a+b;
                n = n*10;
            }
            int p = nume.get(n);
            String c = "";
            for(int i=0; i<p; i++){
                c = c + b.charAt(i);
            }
            c += "(";
            for(int i=p; i<b.length(); i++){
                c = c + b.charAt(i);
            }
            c += ")";
            b = c;
        }

        return a+b;
    }
}
