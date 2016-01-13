/*
  DP.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int pmax = nums[0];
        int pmin = nums[0];
        int mp = nums[0];

        for(int i=1; i<nums.length; i++){
            int temp = pmax;
            pmax = max(nums[i], nums[i]*pmax, nums[i]*pmin);
            pmin = min(nums[i], nums[i]*temp, nums[i]*pmin);
            mp = Math.max(pmax, mp);
        }
        return mp;
    }
    public int max(int a, int b, int c) {
        if (a>=b && a>=c) return a;
        else if(b>=c) return b;
        else return c;
    }
    public int min(int a, int b, int c) {
        if (a<=b && a<=c) return a;
        else if(b<=c) return b;
        else return c;
    }
}
