/*
  HashMap.
*/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int l = nums.length;
        if(l<2) return false;

        Map map = new HashMap();
        for(int i = 0; i < l; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < l; i++){
            if((int)map.get(nums[i])!=i) return true;
        }
        return false;
    }
}
