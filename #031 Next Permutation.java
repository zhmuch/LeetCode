/*
  逆序列
*/

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int l = nums.length;
        if(l<2) return;
        
        int i = l-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if (i<0){
            Arrays.sort(nums);
            return;
        }
        
        int j = i+1;
        while(j<l && nums[j]>nums[i]){
            j++;
        }
        
        swap(nums, i, j-1);
        for (int k=i+1; k<=(i+l)/2; k++){
            swap(nums, k, i+l-k);
        }
    }
    
    public void swap(int[] nums, int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
