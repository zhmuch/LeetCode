public class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if(l<2) return l;
        int last = 0;

        for(int i=1; i<l; i++){
            if (nums[i]!=nums[last]){
                last++;
                nums[last]=nums[i];
            }
        }
        return last+1;
    }
}
