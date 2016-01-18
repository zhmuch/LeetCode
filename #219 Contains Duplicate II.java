/*
  Use a k-size window.
*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = nums.length;
        if(l<2) return false;

        int start = 0;
        int end = 0;
        Set<Integer> temp = new HashSet<Integer>();
        for(int i=0; i<l; i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                end++;
            }
            else return true;

            if(end-start>k){
                temp.remove(nums[start]);
                start++;
            }
        }
        return false;
    }
}
