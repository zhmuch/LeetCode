/*
  映射找环法。
  数组序号：0..n
  数范围  ：1--n
  所有：序号＝包含数字的自成环。
  但对于重复数字，则会另构成一个环。
  
  找环起点，通过slow，fast两个指针。可画图证明。
*/

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int find=0;
        while(find!=slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}
