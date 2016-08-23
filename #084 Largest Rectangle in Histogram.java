/*
  直方图最大矩形面积问题。
*/

public class Solution {
    public int largestRectangleArea(int[] height) {
        int l = height.length;
        if(l == 0) return 0;
        
        int[] arr = new int[l];
        arr[0] = height[0];
        int max = arr[0];
        
        for(int i = 1; i < l; i++){
            arr[i] = height[i];
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] > arr[i]){
                    max = Math.max(arr[j] * (i-j), max);
                    arr[j] = arr[i];
                }
                else break;
            }
        }
        
        for(int i = 0; i < l; i++){
            max = Math.max((l - i) * arr[i], max);
        }
        
        return max;
    }
}
