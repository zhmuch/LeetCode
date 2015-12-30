/*
  ^_^
*/

public class Solution {
    public int search(int[] nums, int target) {
        int index = 0;
        int l = nums.length;
        
        for(int i=0; i<l; i++){
            if(nums[i] == target) return index;
            index++;
        }
        return -1;
    }
}
