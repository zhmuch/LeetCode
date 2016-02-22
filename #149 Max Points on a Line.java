/*
  Not accurate.
*/

import java.util.*;


public class Solution {
    public int maxPoints(Point[] points) {
        Hashtable<Set, Integer> set = new Hashtable<>();
        if (points.length<1) return 0;
        if (points.length == 1) return 1;
        int res = 1;

        for(Point tempa : points){
            for(Point tempb : points){
                if (tempa.equals(tempb)) continue;
                else{
                    double k, b;
                    if (tempa.x == tempb.x){
                        k = 10000;
                        b = tempa.x;
                    }
                    else {
                        k = ((double)(tempa.y-tempb.y))/((double)(tempa.x-tempb.x));
                        b = (double)tempa.y - k*(double)(tempa.x);
                    }
                    // System.out.println(k);
                    // System.out.println(b);
                    Set temp = new HashSet<>();
                    temp.add((int)k);
                    temp.add((int)b);

                    if(set.containsKey(temp)) {
                        int newCount = set.get(temp)+1;
                        res = Math.max(res, newCount);
                        set.put(temp,newCount);
                    }
                    else set.put(temp,1);
                }
            }
        }
        System.out.println(res);
        int n = 1;
        while(n*(n-1) < res){
            n++;
        }
        return n;
    }
}
