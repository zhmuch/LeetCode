/*
  Others work
*/
import java.util.*;


public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length; // 0/1/2 points
        int res = 1; // at least 1 point
        Map<String, Integer> map = new HashMap<String, Integer>(); // line,count
        for (int i = 0; i < points.length; i++) {
            int max = 0;
            int countSame = 0; // # of same points
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y ) countSame++; // same point
                else {
                    String key = normalize(points[i], points[j]); // a|b|c
                    if (map.containsKey(key)) { // on the line
                        int count = map.get(key) + 1;
                        map.put(key, count); // update count
                        if (count > max) max = count; // update max
                    } else { // not on any line
                        map.put(key, 1);
                        if (max == 0) max++; // update max
                    }
                }
            }
            res = Math.max(res, max + countSame + 1); // +1 for the start point
            map.clear(); // clear map for next point
        }
        return res;
    }

    /**
     * use ax + by = c to represent a line and a|b|c as a key for that line
     * a, b, c should be normalized, how?
     *
     * special case, vertical, horizontal
     */
    public String normalize(Point p1, Point p2) {
        int a, b;
        float c;
        if (p1.x == p2.x) { // vertical
            b = 0;
            a = 1;
            c = p1.x;
        } else if (p1.y == p2.y) { // horizontal
            a = 0;
            b = 1;
            c = p2.y;
        } else { // ax + by = c
            int dx = p1.x - p2.x;
            int dy = p1.y - p2.y;
            /*reduce to simplest*/
            int gcd = gcd(Math.abs(dx), Math.abs(dy));
            a = dy / gcd;
            b = dx / gcd;
            if (a * b < 0) { // force a to be negative
                a = -1 * Math.abs(a);
                b = Math.abs(b);
            } else { // force both positive
                a = Math.abs(a);
                b =  Math.abs(b);
            }
            c = a * p1.x + b * p1.y; // c = ax + by
        }
        return a + "|" + b + "|" + c; // key format
    }

    /**
     * recursively calculate the greateset common divisor of two numbers
     */
    public int gcd(int a, int b) {
        if (b == 0) return a; // stop when b == 0, a is the gcd
        return gcd(b, a % b); // a <- b, b <- a % b
    }

}



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
