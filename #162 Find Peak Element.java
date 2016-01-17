/*
  二分法，如果nums[k]<nums[k+1]，则peak在k右侧；反之在左侧。
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;

        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<nums[mid+1]) left=mid+1;
            else right=mid;
        }
        return left;
    }
}
