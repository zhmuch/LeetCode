public class Solution {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        if(l==0) return 1;
        Arrays.sort(nums);

        for(int i=0; i<l; i++){
            if(nums[i]>0 && nums[i]<=l) nums[nums[i]-1] = nums[i];
        }
        for(int i=0; i<l; i++){
            if(nums[i]!=(i+1)) return i+1;
        }
        return l+1;
    }
}
