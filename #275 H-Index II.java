//  Naive Solution;
//  Same as #274;
//  O(n);

public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length < 1)
            return 0;

        int len = citations.length;
        int h = 0;
        for(int i = 0; i < len; i++){
            int t = Math.min(len - i, citations[i]);
            h = Math.max(h, t);
        }

        return h;
    }
}
