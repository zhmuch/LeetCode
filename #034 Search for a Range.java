public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] notf = {-1,-1};
        int[] found = new int[2];
        if (nums.length==0) return notf;
        boolean flag = false;
        int i;

        for (i=0; i<nums.length; i++){
            if (nums[i]==target){
                found[0] = i;
                flag = true;
                break;
            }
        }

        if (flag){
            for (int j=i; j<nums.length; j++){
                if (nums[j]!=target) break;
                found[1] = j;
            }
            return found;
        }
        else return notf;
    }
}
