/*
  二分查找。
*/

public class Solution {
    public int findMin(int[] nums) {
        int l = nums.length;
        if(l==1 || nums[l-1]>nums[0]) return nums[0];

        int left=0;
        int right=l-1;

        while(right-left>1){
            int mid=(left+right)/2;
            if(nums[mid]>nums[0]) left=mid;
            else right=mid;
        }
        if(nums[right]>nums[left]) return nums[right+1];
        else return nums[right];
    }
}
