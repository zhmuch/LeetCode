//  Same as #300;

import java.util.*;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;

        int[] tri = new int[3];
        int len = 0;

        for(int x : nums){
            int i = Arrays.binarySearch(tri, 0, len, x);
            if(i < 0)
                i = -(i + 1);
            tri[i] = x;
            if(i == len)
                len++;
            
            if(len == 3)
                return true;
        }
        
        return false;
    }
}

//  Simple;
import java.util.*;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;

        int[] tri = new int[3];
        tri[0] = nums[0];
        int len = 1;

        for(int x : nums){
            
            int i = 0;
            while(i < len && tri[i] < x)
                i++;

            if(i < len && tri[i] == x)
                continue;
            
            if(i == len)
                len++;

            tri[i] = x;
            
            if(len == 3)
                return true;
        }
        return false;
    }
}
