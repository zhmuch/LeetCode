//  Other`s
//  Using TreeSet;
import java.util.*;

public class Solution {  
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {  
        //input check  
        if(k<1 || t<0 || nums==null || nums.length<2) return false;  
          
        SortedSet<Long> set = new TreeSet<Long>();  
          
        for(int j=0; j<nums.length; j++) {  
            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);  
            if(!subSet.isEmpty()) return true;  
              
            if(j>=k) {  
                set.remove((long)nums[j-k]);  
            }  
            set.add((long)nums[j]);  
        }  
        return false;  
    }  
}


//  Same as #219;
//  TLE...
//  Need to use Binary Search Tree;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(nums == null || t < 0 || k < 1 || nums.length < 2)
            return false;
        int l = nums.length;

        int start = 0;
        int end = 0;
        Hashtable<Integer, Integer> table = new Hashtable<>();

        for(int i = 0; i < l; i++){
            if(table.containsKey(nums[i]) && table.get(nums[i]) > 0)
                return true;

            for(int tmp = nums[i] - t; tmp <= nums[i] + t; tmp++)
                if(table.containsKey(tmp))
                    table.put(tmp, table.get(tmp) + 1);
                else
                    table.put(tmp, 1);
            end++;

            if(end - start > k){
                for(int tmp = nums[start] - t; tmp <= nums[start] + t; tmp++)
                    table.put(tmp, table.get(tmp) - 1);
                start++;
            }
        }
        return false;
    }
}
