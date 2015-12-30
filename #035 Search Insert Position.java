public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = nums.length;
        if (l==0 || target < nums[0]) return 0;
        if (target > nums[l-1]) return l;

        int left=0;
        int right=l-1;

        while(right-left>1){
            int mid = (left+right)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid] < target) left = mid;
            else right = mid;
        }
        if (nums[left]==target) return left;
        else return right;
    }
}
