/*
  DP Problem
*/

public class Solution {
    public int trap(int[] height) {
        int l = height.length;
        if (l < 3) return 0;
        int result = 0;
        int maxindex = 0;
        int max = height[maxindex];

        for (int i = 1; i < l; i++){
            if (height[i] >= max){
                if (i - maxindex > 1){
                    for (int j = maxindex; j<i; j++){
                        result += max - height[j];
                    }
                }
                maxindex = i;
                max = height[maxindex];
            }
            else{
                if (height[i] > height[i-1]){
                    int j = i - 1;
                    while(height[i] > height[j]){
                        result += height[i] - height[j];
                        height[j] = height[i];
                        j--;
                    }
                }
            }
        }
        return result;
    }
}
