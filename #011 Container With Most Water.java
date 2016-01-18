/*
  Two Pointer.
  向中间搜索，矮的一方移动，因为如果保留矮的一方，后续最大容积仍小于此矮容器。
*/

public class Solution {
    public int maxArea(int[] height) {
        int l = height.length;
        if(l<2) return 0;

        int max=0;
        int left=0, right=l-1;
        while(left<right){
            int temp = Math.min(height[left], height[right])*(right-left);
            max = Math.max(temp, max);
            if (height[left] < height[right]) {
                left++;
            }
            else right--;
        }
        return max;
    }
}
