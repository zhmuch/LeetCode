//  Lots of boundary check;
//  Using Long to avoid overflow;
import java.util.*;

public class Solution {

    String num;

    public boolean isAdditiveNumber(String num) {

        if(num == null || num.length() < 3)
            return false;

        this.num = num;
        int max = num.length() / 2;

//        System.out.println("max: " + max);

        if(num.charAt(0) == '0'){
            if(num.charAt(1) == '0'){
                if(dfs(0, 0, 1, 2))
                    return true;
            }
            else
                for(int j = 0; j < max; j++){
                    long prepre = 0;
                    long pre = Long.parseLong(num.substring(1, j + 2));
                    if(dfs(prepre, pre, j + 1, j + 2))
                        return true;
                }
        } else {
            for(int i = 0; i < max; i++){
                if(num.charAt(i + 1) == '0'){
                    if(dfs(Long.parseLong(num.substring(0, i + 1)), 0, i + 1, i + 2))
                        return true;
                }
                else
                    for(int j = 0; i + j + 2 < num.length() && j < max; j++){
//                        System.out.println("i: " + i + "  j: " + j);
                        long prepre = Long.parseLong(num.substring(0, i + 1));
                        long pre = Long.parseLong(num.substring(i + 1, i + j + 2));
                        if(dfs(prepre, pre, Math.max(i, j) + 1, i + j + 2))
                            return true;
                    }
            }
        }


        return false;
    }

    private boolean dfs(long prepre, long pre, int digits, int idx) {

//        System.out.println("prepre: " + prepre + "  pre: " + pre + "  digits: " + digits + "  idx: " + idx);

        if(idx >= num.length())
            return true;

        if(num.charAt(idx) == '0' && digits > 1)
            return false;

        if(num.length() - idx < digits)
            return false;

        boolean res = false;

        //  digits
        Long pos = Long.parseLong(num.substring(idx, idx + digits));
        if(pos == prepre + pre){
            res = dfs(pre, pos, digits, idx + digits);
        }

        if(res)
            return true;

        //  digits + 1;
        if(num.charAt(idx) != '0' && idx + digits + 1 <= num.length() && digits < 9){
            Long poss = Long.parseLong(num.substring(idx, idx + digits + 1));
            if(poss == prepre + pre){
                res = dfs(pre, poss, digits + 1, idx + digits + 1);
            }
        }


        return res;
    }
}


//  Some bugs;

import java.util.*;

public class Solution {

    String num;

    public boolean isAdditiveNumber(String num) {

        if(num == null || num.length() < 3)
            return false;

        this.num = num;
        int max = Math.min(num.length() / 2, 9);

//        System.out.println("max: " + max);

        if(num.charAt(0) == '0'){
            if(num.charAt(1) == '0'){
                if(dfs(0, 0, 1, 2))
                    return true;
            }
            else
                for(int j = 0; j < max; j++){
                    int prepre = 0;
                    int pre = Integer.parseInt(num.substring(1, j + 2));
                    if(dfs(prepre, pre, j + 1, j + 2))
                        return true;
                }
        } else {
            for(int i = 0; i < max; i++){
                if(num.charAt(i + 1) == '0'){
                    if(dfs(Integer.parseInt(num.substring(0, i + 1)), 0, i + 1, i + 2))
                        return true;
                }
                else
                    for(int j = 0; i + j < max && j < max; j++){
                        int prepre = Integer.parseInt(num.substring(0, i + 1));
                        int pre = Integer.parseInt(num.substring(i + 1, i + j + 2));
                        if(dfs(prepre, pre, Math.max(i, j) + 1, i + j + 2))
                            return true;
                    }
            }
        }


        return false;
    }

    private boolean dfs(int prepre, int pre, int digits, int idx) {

//        System.out.println("prepre: " + prepre + "  pre: " + pre + "  digits: " + digits + "  idx: " + idx);

        if(idx >= num.length())
            return true;

        if(num.charAt(idx) == '0' && digits > 1)
            return false;

        if(num.length() - idx < digits)
            return false;

        boolean res = false;

        //  digits
        int pos = Integer.parseInt(num.substring(idx, idx + digits));
        if(pos == prepre + pre){
            res = dfs(pre, pos, digits, idx + digits);
        }

        if(res)
            return true;

        //  digits + 1;
        if(num.charAt(idx) != '0' && idx + digits + 1 <= num.length() && digits < 9){
            int poss = Integer.parseInt(num.substring(idx, idx + digits + 1));
            if(poss == prepre + pre){
                res = dfs(pre, poss, digits + 1, idx + digits + 1);
            }
        }


        return res;
    }
}
