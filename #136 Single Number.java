/*
    ^ : 异或。
    N1 ^ N2 ^ N3 ^...=(Ni ^ Nj) ^ ...  任意i，j。
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i=1; i<nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}

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
