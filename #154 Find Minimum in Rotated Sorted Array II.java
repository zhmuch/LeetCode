/*
  Modified from #153.
*/

public class Solution {
    public int findMin(int[] nums) {
        int l = nums.length;
        if(l==1 || nums[l-1]>nums[0]) return nums[0];

        int left=0;
        int right=l-1;
        while(right>=0 && nums[right]==nums[0]){
            right--;
        }
        if(right<0) return nums[0];
        
        while(right-left>1){
            int mid=(right+left)/2;
            if(nums[mid]>=nums[0]) left=mid;
            else right=mid;
        }

        if(nums[right]>nums[left]) return nums[right+1];
        else if(nums[right]<nums[left]) return nums[right];
        else {
            while(nums[right]==nums[left]){
                right++;
            }
            return nums[right];
        }
    }
}
