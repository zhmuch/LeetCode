import java.util.*;

public class Solution {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    
        if(root != null) {
            List<Integer> tmp = new LinkedList<>();
            dfs(root, sum, tmp);
        }
        
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> tmp) {

        if(root == null)
            return;

        tmp.add(root.val);

        if(root.left == null && root.right == null && sum == root.val)
            res.add(new LinkedList<>(tmp));
        else{
            dfs(root.left, sum - root.val, tmp);
            dfs(root.right, sum - root.val, tmp);
        }

        tmp.remove(tmp.size() - 1);
    }
}
