import java.util.*;

public class Solution {
    public boolean isSelfCrossing(int[] x) {
        int l = x.length;
        if(l < 4)
            return false;

        for(int i=3; i<l; i++){
            if(i >= 3 && x[i-1] <= x[i-3] && x[i] >= x[i-2]){
                // System.out.println("Case1 i = " + i);
                return true;
            }
            if(i >= 4 && x[i-1] == x[i-3] && (x[i] + x[i-4] >= x[i-2])){
                // System.out.println("Case2 i = " + i);
                return true;
            }
            if(i >= 5 && x[i-2] > x[i-4] && (x[i-4] + x[i]) >= x[i-2] && (x[i-1] + x[i-5]) >= x[i-3] && x[i-1] <= x[i-3]){
                // System.out.println("Case3 i = " + i);
                return true;
            }
        }
        
        return false;
    }
}
