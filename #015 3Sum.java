/*
  Two pointer, set smallest nums[i] first, then 2Sum problem.
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int l = nums.length;
        if (l<3) return result;
        Arrays.sort(nums);
        int i = 0;

        while (i<l-2 && nums[i]<=0) {
            int down = i+1;
            int up = l-1;
            while (down < up) {
                if (nums[i] + nums[down] + nums[up] == 0){
                    List<Integer> res = new LinkedList<Integer>();
                    res.add(nums[i]);
                    res.add(nums[down]);
                    res.add(nums[up]);
                    result.add(res);
                    
                    down++;       // Maybe there is a bug. 
                    up--;
                    while (nums[down-1] == nums[down] && down < up) down++;
                    while (nums[up+1] == nums[up] && down < up) up--;
                }
                else if (nums[i] + nums[down] + nums[up] > 0) {
                    up--;
                } else {
                    down++;
                }
            }
            i++;
            while (i<l-2 && nums[i-1] == nums[i]) i++;
        }
        return result;
    }
}

