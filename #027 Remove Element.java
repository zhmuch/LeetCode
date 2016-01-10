public class Solution {
    public int removeElement(int[] nums, int val) {
        int l = nums.length;
        if (l==0) return l;

        Arrays.sort(nums);
        int left = 0;
        int right = l-1;
        int mid=0;

        while(right-left>1){
            mid = (left+right)/2;
            if (nums[mid] == val) break;
            else if (nums[mid]<val){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        int i=0;
        boolean flag=false;
        if(nums[left]==val) {i=left; flag=true;}
        if(nums[mid]==val) {i=mid; flag=true;}
        if(nums[right]==val) {i=right; flag=true;}

        if(flag){
            int j=i;
            int count=0;
            while(j>=0 && nums[j]==val){
                j--;
                count++;
            }
            int start = j+1;

            j=i;
            while(j<=l-1 && nums[j]==val){
                j++;
                count++;
            }
            int end = j-1;

            if(end<l-1){
                int in = start;
                int out = l-1;
                while(out>end && in<=end){
                    nums[in] = nums[out];
                    in++;
                    out--;
                }
            }
            return l-count+1;
        }
        else{
            return l;
        }
    }
}
