import java.util.Arrays;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        if(l==0) return 1;
        Arrays.sort(nums);
        if(nums[l-1]<=0) return 1;

        int left = 0;
        int right = l-1;
        int fpos;
        while(right-left>1){
            int mid = (left+right)/2;

            if(nums[mid]==0){
                fpos=findNext(nums, mid);
                left = fpos-1;
                right = fpos;
                break;
            }

            if(nums[mid]>0){
                right = mid;
            }
            else{
                left = mid;
            }
        }

        if(nums[left]>0 && nums[right]>0) fpos = left;
        else fpos = right;

        int ref = 1;
        while(fpos<l){
            if(nums[fpos]==ref){
                fpos = findNext(nums, fpos);
                if(fpos==l-1 && nums[l-1]==ref) return ref+1;
                ref++;
            }
            else{
                return ref;
            }
        }
        return ref;

    }

    public int findNext(int[] nums, int index) {
        int temp = nums[index];
        while (index<nums.length && nums[index] == temp) {
            index++;
        }
        return index;
    }

}
