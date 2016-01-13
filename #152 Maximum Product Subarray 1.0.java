/*
  搜索法，按"0"分段，找每段最大乘积。
  可用DP，同时记录最大值、最小值（负），遍历一遍即可。
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int left = 0;
        while(left<nums.length && nums[left]==0){
            left++;
        }
        if (left == nums.length) return 0;

        int right = left;
        int max;
        if(left>0){
            max = Math.max(0, nums[left]);
        }
        else max = nums[left];
        boolean zero = false;
        while(right<nums.length){
            if(nums[right]==0){
                zero = true;
                max = Math.max(maxP(nums, left, right-1), max);

                left=right;
                while(left<nums.length && nums[left]==0){
                    left++;
                }
                right = left;
            }
            else{
                right++;
            }
        }
        if (nums[right-1] != 0){
            max = Math.max(maxP(nums, left, right-1), max);
        }
        if (zero){
            return Math.max(max, 0);
        }
        else return max;
    }

    public int maxP(int[] nums, int left, int right){
        int maxp;
        int prod = 1;
        int count = 0;
        if (left == right) return nums[left];

        for(int i=left; i<=right; i++){
            prod *= nums[i];
            if (nums[i]<0) count++;
        }
        if (count%2 == 0) return prod;
        else{
            int prol = 1;
            for(int i=left; i<=right; i++){
                prol *= nums[i];
                if(nums[i]<0) break;
            }

            int pror = 1;
            for(int i=right; i>=left; i--){
                pror *= nums[i];
                if(nums[i]<0) break;
            }

            if(prol < pror) return prod/pror;
            else return prod/prol;
        }
    }
}
