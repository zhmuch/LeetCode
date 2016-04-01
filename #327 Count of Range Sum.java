import java.util.*;

public class Solution {
    long[] sums;
    int lower, upper;

    public int countRangeSum(int[] nums, int lower, int upper) {

        this.lower = lower;
        this.upper = upper;

        sums = new long[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            sums[i] = sums[i - 1] + nums[i];

        return mergeCount(0, nums.length - 1);

    }

    private int mergeCount(int left, int right){

        if(right < left)
            return 0;

        int mid = (left + right) / 2;
        int count = mergeCount(left, mid) + mergeCount(mid + 1, right);

        long[] tmp = new long[right - left + 1];

        int ind = left, i = left, j = mid + 1;

        while(i <= mid){

        }

        return count;

    }

}
