/**
 * Same as #102
 */

public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
                res.add(0, tmp);
        }

        return res;
    }
}
