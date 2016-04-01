/*
  Super FAST!!
  Use Array instead of List<>;
*/
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        permute(list, nums, 0);
        return list;
    }

    private void permute(List<List<Integer>> list, int[] nums, int start){
        if(start == nums.length - 1){
            List<Integer> l = new LinkedList<>();
            for(int n:nums)
                l.add(n);
            list.add(l);
        }
        else{
            for(int i=start; i<nums.length; i++){
                int tmp = nums[i];
                nums[i] = nums[start];
                nums[start] = tmp;
                permute(list, nums, start+1);
                tmp = nums[i];
                nums[i] = nums[start];
                nums[start] = tmp;
            }
        }
    }

}

/*
  Naive DFS.
*/

import java.util.*;

public class Solution {
    int[] nums;
    List<List<Integer>> res;
    Set<Integer> used;
    LinkedList<Integer> tmp;

    public List<List<Integer>> permute(int[] nums) {

        this.nums = nums;
        res = new LinkedList<>();
        used = new HashSet<>();
        tmp = new LinkedList<>();

        generate(0);

        return res;

    }

    private void generate(int s){

        if(s == nums.length){
            res.add(new LinkedList<>(tmp));
            return;
        }

        for(int i = 0; i < nums.length; i++)
            if(!used.contains(nums[i])){
                used.add(nums[i]);
                tmp.add(nums[i]);
                generate(s + 1);
                used.remove(nums[i]);
                tmp.removeLast();
            }
        return;

    }
}
