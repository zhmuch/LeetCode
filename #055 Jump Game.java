/*
  贪心。
*/

public class Solution {
    public boolean canJump(int[] nums) {
        int l = nums.length;
        if (l < 2) return true;
        if (nums[0]==0) return false;

        int max = nums[0];
        for(int i=1; i<l; i++){
            if (i<=max) {
                if (nums[i] + i > max) max = nums[i] + i;
                if (max >= (l-1)) return true;
            }
            else break;
        }

        return false;
    }
}
