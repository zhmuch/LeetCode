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
