/*
  DFS.
  BackTracking.
*/

public class Solution {
    List<List<Integer>> result;
    List<Integer> sol;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        sol = new ArrayList<>();
        Arrays.sort(candidates);
        search(candidates, target, 0, 0);
        return result;
    }

    public void search(int[] candidates, int target, int sum, int level) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(sol));
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            sum+=candidates[i];
            sol.add(candidates[i]);
            search(candidates, target, sum, i);
            sum-=candidates[i];
            sol.remove(sol.size()-1);
        }
    }
}
