//  Simple Binary Search;
import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length < 1)
            return 0;

        int len = citations.length;
        int left = 0, right = len - 1;

        while(left < right){
            int med = (left + right) / 2;

            if(len - med == citations[med])
                return len - med;
            else if(len - med > citations[med])
                left = med + 1;
            else
                right = med;
        }

        int med = (left + right) / 2;
        return Math.min(len - med, citations[med]); 
    }
}



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
