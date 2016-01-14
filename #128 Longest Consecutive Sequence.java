public class Solution {
    public int longestConsecutive(int[] nums) {
        int l = nums.length;
        if(l<1) return 0;

        Arrays.sort(nums);
        int max = 1;
        int len = 1;
        for(int i=1; i<l; i++){
            if(nums[i]-nums[i-1]==1) len++;
            else if(nums[i]!=nums[i-1]){
                max = Math.max(max, len);
                len = 1;
            }
        }
        max = Math.max(max, len);
        return max;
    }
}
