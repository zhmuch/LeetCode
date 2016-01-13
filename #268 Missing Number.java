public class Solution {
    public int missingNumber(int[] nums) {
        int l = nums.length;
        long esum = (l*(l+1))/2;
        long sum = 0;

        for(int i=0; i<l; i++){
            sum+=nums[i];
        }
        return (int)(esum-sum);
    }
}
