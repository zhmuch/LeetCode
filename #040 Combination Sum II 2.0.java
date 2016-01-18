/*
  减支。
*/

import java.util.*;

public class Solution {
    List<List<Integer>> result;
    List<Integer> sol;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        sol =  new ArrayList<>();
        Arrays.sort(candidates);
        search(candidates, target, 0, 0);
        return result;
    }
    public void search(int[] candidates, int target, int sum, int level) {
        if(sum > target) return;
        if(sum == target) {
            result.add(new ArrayList<>(sol));
            return;
        }
        int i=level;
        while (i<candidates.length) {
            if(candidates[i]<=target){
                sum += candidates[i];
                sol.add(candidates[i]);
                search(candidates, target, sum, i+1);
                sum-=candidates[i];
                sol.remove(sol.size()-1);
                while(i<candidates.length-1 && candidates[i]==candidates[i+1]) i++;
            }
            i++;
        }
    }
}
