public class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if(l<3) return l;
        int llast = 0;
        int last = 1;
        for(int i=2; i<l; i++){
            if (nums[i]!=nums[last] || nums[i]!=nums[llast]){
                llast++;
                last++;
                nums[last]=nums[i];
            }
        }
        return last+1;
    }
}
