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
