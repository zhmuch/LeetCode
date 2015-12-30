/*
  Modified from #033.
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        int l = nums.length;
        if (l==0) return false;
        int left=0;
        int right=l-1;

        while(left<=right){
            int mid = (left+right)/2;
            if (nums[mid]==target || nums[left] == target || nums[right] == target) return true;
            if (nums[mid]>nums[left]) {
                if(nums[mid]>target && target>nums[left]) right = mid-1;
                else left = mid+1;
            }
            else if (nums[mid]<nums[left]){
                if(nums[mid]<target && target<nums[right]) left = mid+1;
                else right = mid-1;
            }
            else {
                while(right-left>1 && nums[left+1] == nums[left]){
                    left++;
                }
                left++;
            }
        }
        return false;
    }
}
