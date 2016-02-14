/*
  Happy.
*/

public class Solution {
    public boolean isHappy(int n) {
        if(n<0) return false;
        HashSet<Integer> mid = new HashSet<>();

        while(!mid.contains(n)){
            mid.add(n);
            n = sumSqu(n);
            if (n==1) return true;
        }

        return false;
    }

    public int sumSqu(int n) {
        int sum = 0;

        while(n>=10){
            int t = n%10;
            sum += t*t;
            n = n/10;
        }
        return sum+n*n;
    }
}
