import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue;
        Queue<TreeNode> next = new LinkedList<>();

        next.offer(root);

        while(!next.isEmpty()){
            queue = next;
            next = new LinkedList<>();
            List<Integer> tmp = new ArrayList<>();

            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                if(t != null) {
                    tmp.add(t.val);
                    next.offer(t.left);
                    next.offer(t.right);
                }
            }
            
            if(!tmp.isEmpty())
                res.add(tmp);
        }

        return res;
    }
}
