/*
  dichotomy.
*/

public class Solution {
    public int search(int[] nums, int target) {
        int l = nums.length;
        if (l==0) return -1;
        int left=0;
        int right=l-1;

        while(left<=right){
            int mid = (left+right)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid]>nums[left]) {
                if(nums[mid]>target && target>=nums[left]) right = mid;
                else left = mid;
            }
            else if (nums[mid]<nums[left]){
                if(nums[mid]<target && target<=nums[right]) left = mid;
                else right = mid;
            }
            else left++;
        }
        return -1;
    }
}
