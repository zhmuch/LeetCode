/*
  DP问题。
  可尝试分治。
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length<2) return nums[0];

        int index = 0;
        int sum = 0;
        int max = nums[0];

        while(index<nums.length){
            sum += nums[index];
            max = Math.max(max, sum);
            if (sum<0){
                sum = 0;
            }
            index++;
        }
        return max;
    }
}
