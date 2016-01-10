/*
  [1,2,3,4,5,6,7]   k = 3;
  [4,3,2,1] + [7,6,5];
  [5,6,7,1,2,3,4];
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        if (l<2 || k == 0) return;

        int mid = l - (k%l);
        for (int i = 0; i<=(mid-1)/2; i++){
            int temp = nums[i];
            nums[i] = nums[mid-1-i];
            nums[mid-1-i] = temp;
        }
        for (int i = mid; i<=(mid+l-1)/2; i++){
            int temp = nums[i];
            nums[i] = nums[mid+l-1-i];
            nums[mid+l-1-i] = temp;
        }
        for (int i=0; i<=(l-1)/2; i++){
            int temp = nums[i];
            nums[i] = nums[l-1-i];
            nums[l-1-i] = temp;
        }
    }
}
