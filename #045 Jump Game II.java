/*
  Upgraded from #55.
  原理：对于m>n，其分别所需步数满足：step[m]>=step[n]。
*/

public class Solution {
    public int jump(int[] nums) {
        int l = nums.length;
        if(l<2) return 0;

        int[] step = new int[l];
        int max = nums[0];
        if(max >= (l-1)) return 1;
        step[0] = 0;
        for(int j=1; j<=max; j++){
            step[j] = step[0] + 1;
        }

        for(int i=1; i<l; i++){
            if (i + nums[i] > max) {
                int pmax = max;
                max = nums[i] + i;
                if (max >= (l-1)) return step[i]+1;
                for(int j=pmax+1; j<=max; j++){
                    step[j] = step[i] + 1;
                }
            }
        }
        return -1;
    }
}
