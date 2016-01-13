/*
  类似 连续子串的最大值（经典DP问题）
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = nums.length;
        if (l<1) return 0;

        int len = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while(end < l && start < l){
            while(sum < s && end < l){
                sum += nums[end];
                end++;
            }
            while(sum >= s && start <= end) {
                len = Math.min(len, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return len==Integer.MAX_VALUE ? 0 : len;
    }
}
