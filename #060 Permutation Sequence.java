import java.util.LinkedList;

public class Solution {
    public String getPermutation(int n, int k) {
        if(n == 1)
            return "1";

        String r = "";

        LinkedList<Integer> ref = new LinkedList<>();

        int s = 1;
        for(int i=1; i<=n; i++) {
            ref.add(i);
            s *= i;
        }

        for(int i=n; i>0; i--){
            s /= i;
            if(k != 0 && k % s == 0) {
                r = r + ref.remove(k / s - 1);
                break;
            }
            r = r + ref.remove(k / s);
            k %= s;
        }

        
        while(!ref.isEmpty())
            r = r + ref.removeLast();
      
        return r;
    }
}
