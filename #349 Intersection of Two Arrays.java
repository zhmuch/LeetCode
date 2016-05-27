import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);

        HashSet<Integer> inter = new HashSet<>();
        for(int i = 0; i < nums2.length; i++)
            if(set.contains(nums2[i]))
                inter.add(nums2[i]);
        
        int[] res = new int[inter.size()];
        int j = 0;
        for(Integer i : inter){
            res[j] = i;
            j++;
        }
        
        return res;
    }
}
