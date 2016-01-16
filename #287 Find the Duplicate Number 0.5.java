/*
  O(n^2)
*/

public class Solution {
    public int findDuplicate(int[] nums) {
        int l = nums.length;
        for(int ref=1; ref<=l-1; ref++) {
            boolean show = false;
            for (int i = 0; i < l; i++) {
                if (nums[i]==ref) {
                    if(show) return ref;
                    show = true;
                }

            }
        }
        return -1;
    }
}
