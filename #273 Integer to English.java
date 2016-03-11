import java.util.*;

public class Solution {
    public String numberToWords(int num) {
        String[] ref = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                        "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"};

        if (num == 0)
            return "Zero";

        // 1000, Thousand
        // 1000,000 Million
        // 1000,000,000 Billion

        String res = "";
        String[] sta = {"", "Thousand", "Million", "Billion"};
        int i = 0;
        int tmp;

        while(num != 0) {

            tmp = num % 1000;
            if(tmp != 0){
                if(i == 0)
                    res = super3(tmp, ref) + res;
                else {
                    if (res.equals(""))
                        res = super3(tmp, ref) + " " + sta[i];
                    else
                        res = super3(tmp, ref) + " " + sta[i] + " " + res;
                }
            }

            num = num / 1000;
            i++;
        }
        return res;
    }

    public String super3(int n, String[] ref) {
        if (n == 0)
            return "Zero";

        if (n < 100)
            return super2(n, ref);
        else if(n % 100 == 0)
            return ref[n / 100] + " Hundred";
        else
            return ref[n / 100] + " Hundred "+ super2(n % 100, ref);

    }

    public String super2(int n, String[] ref) {
        if (n == 0)
            return "";
        else if (n < 20)
            return ref[n];
        else if(n % 10 == 0)
            return ref[(n / 10) + 18];
        else
            return ref[(n / 10) + 18] + " " + ref[n % 10];
    }
}
