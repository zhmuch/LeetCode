import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
        int l = citations.length;
        if(l<1) return 0;

        Arrays.sort(citations);
        int h = 0;
        for(int i=0; i<l; i++){
            int t = Math.min(l-i, citations[i]);
            h = Math.max(h, t);
        }

        return h;
    }
}
