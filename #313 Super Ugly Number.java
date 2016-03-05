/*
  Time Limit Exceed.
*/

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int res = 0;
        List<Integer>[] l = new LinkedList[len];

        for(int j=0; j<len; j++){
            l[j] = new LinkedList();
            l[j].add(1);
        }

        for(int i=0; i<n; i++){
            res = l[0].get(0);
            
            for(int j=1; j<len; j++)
                if(l[j].get(0) < res){
                    res = l[j].get(0);
                }
            
            for(int j=0; j<len; j++){
                if(l[j].get(0) == res){
                    l[j].remove(0);
                }
                
                l[j].add(res * primes[j]);
            }
        }

        return res;
    }
}
