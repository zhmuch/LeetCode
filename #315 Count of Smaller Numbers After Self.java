import java.util.*;

public class Solution {
    int[] count;
    int[] mapIdx;

    public List<Integer> countSmaller(int[] nums) {

        count = new int[nums.length];
        mapIdx = new int[nums.length];
        List<Integer> res = new LinkedList<>();

        for(int i=0; i<nums.length; i++)
            mapIdx[i] = i;

        mergesort(nums, 0, nums.length - 1);

        for(int i=0; i<nums.length; i++)
            res.add(count[i]);

        return res;

    }

    private void mergesort(int[] nums, int start, int end){

        if(end <= start)
            return;

        int mid = (start + end) / 2;

        mergesort(nums, start, mid);
        mergesort(nums, mid + 1, end);

        merge(nums, start, end);

    }

    private void merge(int[] nums, int start, int end){
    
        int left = start, mid = (start + end) / 2, right = mid + 1;
        int[] sortIdx = new int[end - start + 1];
        int rightNum = 0, ind = 0;

        while(left <= mid && right <= end){
            if(nums[mapIdx[left]] <= nums[mapIdx[right]]){
                sortIdx[ind] = mapIdx[left];
                count[mapIdx[left]] += rightNum;
                ind++;
                left++;
            }
            else{
                sortIdx[ind] = mapIdx[right];
                ind++;
                right++;
                rightNum++;
            }
        }
        
        while(left <= mid){
            sortIdx[ind] = mapIdx[left];
            count[mapIdx[left]] += rightNum;
            ind++;
            left++;
        }
        while(right <= end){
            sortIdx[ind] = mapIdx[right];
            ind++;
            right++;
        }

        for(int i=start; i<=end; i++)
            mapIdx[i] = sortIdx[i - start];

        return;
    }
}
