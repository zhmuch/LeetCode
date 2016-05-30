import java.util.*;

public class Solution {
    List<List<Integer>> res;
    int[] nums;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        if(nums == null || nums.length < 1)
            return res;

        this.nums = nums;
        Arrays.sort(this.nums);
        used = new boolean[nums.length];

        generate(new LinkedList<>(), 0);

        return res;
    }

    private void generate(List<Integer> curr, int x){
        if(x == nums.length)
            res.add(new LinkedList<>(curr));
        else {
            for (int i = 0; i < nums.length; i++)
                if (!used[i]) {
                    used[i] = true;
                    curr.add(nums[i]);
                    generate(curr, x + 1);

                    used[i] = false;
                    curr.remove(curr.size() - 1);

                    while (i < nums.length - 1 && nums[i] == nums[i + 1])
                        i++;
                }
        }
    }
}


//  bugs
//  原因： 在排除重复部分，此算法会低估重复的次数；
import java.util.*;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        
        if(nums == null || nums.length < 1)
            return list;
        
        Arrays.sort(nums);
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
            permute(list, nums, start+1);
            for(int i = start + 1; i < nums.length; i++)
                if(nums[i] != nums[start] && nums[i] != nums[i - 1]) {
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
