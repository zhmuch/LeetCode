//  Be careful with the Greedy choice;


import java.util.*;

public class Solution {
    public int minPatches(int[] nums, int n) {
        int patch = 0;
        long bound = 1;
        int idx = 0;

        while(bound <= n){
            if(idx < nums.length && nums[idx] <= bound){
                bound += nums[idx];
                idx++;
            }
            else{
                patch++;
                bound += bound;
            }
        }

        return patch;
    }
}
