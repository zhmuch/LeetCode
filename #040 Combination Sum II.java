/*
  Modified from #039.
*/

public class Solution {
    List<List<Integer>> result;
    List<Integer> sol;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        sol =  new ArrayList<>();
        Arrays.sort(candidates);
        search(candidates, target, 0, 0);
        removeDuplicate(result);
        return result;
    }
    public void search(int[] candidates, int target, int sum, int level) {
        if(sum > target) return;
        if(sum == target) {
            result.add(new ArrayList<>(sol));
            return;
        }
        for(int i=level; i<candidates.length; i++) {
            sum += candidates[i];
            sol.add(candidates[i]);
            search(candidates, target, sum, i+1);
            sum-=candidates[i];
            sol.remove(sol.size()-1);
        }
    }
    public static void removeDuplicate(List<List<Integer>> list){
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
    }
}
