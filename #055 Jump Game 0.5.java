/*
  递归溢出。
*/

public class Solution {
    public boolean canJump(int[] nums) {
        int l = nums.length;
        if (l<2) return true;
        
        boolean[] flag = new boolean[l];

        flag[0] = true;
        for(int i=1; i<l; i++){
            flag[i] = false;
        }

        search(nums, l - 1, flag);

        return flag[l-1];
    }
    public void search(int[] nums, int index, boolean[] flag) {
        if (flag[flag.length-1]) return;
//        System.out.println("flag.length: " + flag.length );
//        System.out.println("index: " + index);

        if (index <= nums[0]) {
            flag[flag.length-1] = true;
        }
        else{
            for(int i=index-1; i>=1; i--){
//                if (flag[flag.length-1]) return;
                if (flag[i]){
                    continue;
                }
                else if (nums[i] >= (index - i)) {
//                    System.out.println("i: " + i);
                    flag[i] = true;
                    search(nums, i, flag);
                }
            }
        }

    }
}
