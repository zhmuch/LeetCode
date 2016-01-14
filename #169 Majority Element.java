/*
 不同元素相互删除，剩下即为所求。
*/

public class Solution {
    public int majorityElement(int[] nums) {
        int candi = 0;
        int times = 0;
        
        for(int i=0; i<nums.length; i++){
            if(times==0){
                candi = nums[i];
                times++;
            }
            else if(candi == nums[i]) times++;
            else times--;
        }
        return candi; 
    }
}
