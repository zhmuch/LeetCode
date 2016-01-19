public class Solution {
    List<List<Integer>> result;
    List<Integer> sol;
    int[] nums = {1,2,3,4,5,6,7,8,9};
    int count = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        sol = new ArrayList<>();
        search(nums, n, 0, 0, k);
        return result;
    }
    public void search(int[] nums, int target, int sum, int level, int k) {
        if(sum > target) return;
        if (sum == target && count == k) {
            result.add(new ArrayList<>(sol));
            return;
        }
        int i=level;
        while (i<nums.length) {
            if(nums[i]+sum <= target){
                sum += nums[i];
                sol.add(nums[i]);
                count ++;
                search(nums, target, sum, i+1, k);
                sum-=nums[i];
                sol.remove(sol.size()-1);
                count--;
            }
            i++;
        }
    }
}
