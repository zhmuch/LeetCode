public class Solution {
    public void moveZeroes(int[] nums) {
        int l = nums.length;
        if (l<2) return;

        int insert = 0;
        while(insert<l && nums[insert]!=0){
            insert++;
        }
        int search = insert;

        while(search<l){
            if (nums[search] != 0){
                nums[insert] = nums[search];
                nums[search] = 0;
                insert++;
            }
            search++;
        }
    }
}
