public class Solution {
    public int nthUglyNumber(int n) {
        //1, 2, 3.
        int res = 0;
        
        LinkedList<Integer> l1 = new LinkedList();
        LinkedList<Integer> l2 = new LinkedList();
        LinkedList<Integer> l3 = new LinkedList();
        l1.add(1);
        l2.add(1);
        l3.add(1);
        
        for(int i=0; i<n; i++){
            res = Math.min(Math.min(l1.get(0), l2.get(0)), l3.get(0));
            
            if(l1.get(0) == res)
                l1.remove(0);
            if(l2.get(0) == res)
                l2.remove(0);
            if(l3.get(0) == res)
                l3.remove(0);
                
            l1.add(res * 2);
            l2.add(res * 3);
            l3.add(res * 5);
        }
        
        return res;
    }
}
