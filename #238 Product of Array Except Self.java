public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];
        
        for(int i=0; i<l; i++){
            result[i] = 1;
        }

        for(int i=1; i<l; i++){
            result[i] = nums[i-1]*result[i-1];
        }
        int temp = 1;

        for(int i=l-2; i>=0; i--){
            int tt = nums[i];
            nums[i] = temp*nums[i+1];
            result[i] = result[i] * nums[i];
            temp = tt;
        }
        return result;
    }
}
