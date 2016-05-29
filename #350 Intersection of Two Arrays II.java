import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        
        for(int i = 0; i < nums1.length; i++)
            if(table.containsKey(nums1[i]))
                table.put(nums1[i], table.get(nums1[i]) + 1);
            else
                table.put(nums1[i], 1);
        
        LinkedList<Integer> res = new LinkedList<>();
        for(int j = 0; j < nums2.length; j++)
            if(table.containsKey(nums2[j]) && table.get(nums2[j]) > 0){
                res.add(nums2[j]);
                table.put(nums2[j], table.get(nums2[j]) - 1);
            }
        
        int[] r = new int[res.size()];
        int idx = 0;
        for(int i : res)
            r[idx++] = i;
        
        return r;
    }
}
