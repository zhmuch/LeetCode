

// Very poor.

public class Solution {
    public int singleNumber(int[] nums) {
        Hashtable hash = new Hashtable();

        for(int i=0; i<nums.length; i++){
            if(!hash.containsKey(nums[i])){
                hash.put(nums[i], i);
            }
            else{
                hash.remove(nums[i]);
            }
        }

        int l = hash.size();
        int result = -1;
        if(l!=1) return result;
        else {
            Set<Integer> key = hash.keySet();
            for(Integer k: key){
                result = k;
            }
        }
        return result;
    }
}
