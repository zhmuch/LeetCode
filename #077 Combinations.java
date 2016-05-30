import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if(n <= 0 || k <= 0 || k > n)
            return res;

        generate(res, new LinkedList<>(), n, k);

        return res;
    }

    private void generate(List<List<Integer>> res, List<Integer> curr, int n, int k) {
        if(k <= 0){
            res.add(new LinkedList<>(curr));
            return;
        }

        int start = (curr.size() == 0) ? 1 : curr.get(curr.size() - 1) + 1;
        for(int i = start; i <= n; i++){
            curr.add(i);
            generate(res, curr, n, k - 1);
            curr.remove(curr.size() - 1);
        }
    }
}
