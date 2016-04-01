/*
    mergeCount[i, j]
*/
import java.util.*;

public class Solution {
    long[] sums;
    int lower, upper;

    public int countRangeSum(int[] nums, int lower, int upper) {

        this.lower = lower;
        this.upper = upper;

        sums = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            sums[i + 1] = sums[i] + nums[i];

        return mergeCount(0, nums.length);

    }

    private int mergeCount(int left, int right){

        if(left >= right)
            return 0;

        if(left + 1 == right){
            int res = 0;
            if(sums[right] - sums[left] >= lower && sums[right] - sums[left] <= upper)
                res++;
            if(sums[right] < sums[left]){
                long t = sums[right];
                sums[right] = sums[left];
                sums[left] = t;
            }
            return res;
        }

        int mid = (left + right) / 2;
        int count = mergeCount(left, mid) + mergeCount(mid + 1, right);

        long[] tmp = new long[right - left + 1];
        int ind = 0, i = left, j = mid + 1, tl = mid + 1, tr = mid + 1;

        while(i <= mid){
            while(tl <= right && sums[tl] - sums[i] < lower)
                tl++;
            while(tr <= right && sums[tr] - sums[i] <= upper)
                tr++;
            while(j <= right && sums[j] < sums[i])
                tmp[ind++] = sums[j++];
            
            tmp[ind++] = sums[i++];
            count += tr - tl;
        }

        for(int id=0; id<j-left; id++)
            sums[left + id] = tmp[id];

        return count;
    }
}


/*
    mergeCount[i, j)
*/

public class Solution {
    long[] sums;
    int lower, upper;

    public int countRangeSum(int[] nums, int lower, int upper) {

        this.lower = lower;
        this.upper = upper;

        sums = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            sums[i + 1] = sums[i] + nums[i];

        return mergeCount(0, nums.length + 1);

    }

    private int mergeCount(int left, int right){

        if(left >= right - 1)
            return 0;

        int mid = (left + right) / 2;
        int count = mergeCount(left, mid) + mergeCount(mid, right);

        long[] tmp = new long[right - left];
        int ind = 0, i = left, j = mid, tl = mid, tr = mid;

        while(i < mid){
            while(tl < right && sums[tl] - sums[i] < lower)
                tl++;
            while(tr < right && sums[tr] - sums[i] <= upper)
                tr++;
            while(j < right && sums[j] < sums[i]){
                tmp[ind] = sums[j];
                j++;
                ind++;
            }
            tmp[ind] = sums[i];
            i++;
            ind++;
            count += tr - tl;
        }

        for(int id=0; id<j-left; id++)
            sums[left + id] = tmp[id];
//        System.arraycopy(tmp, 0, sums, left, j - left);
        
        return count;

    }

}
