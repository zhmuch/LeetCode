/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue;
        Queue<TreeNode> next = new LinkedList<>();
        boolean flag = false;

        next.offer(root);

        while(!next.isEmpty()){
            queue = next;
            next = new LinkedList<>();
            List<Integer> tmp = new ArrayList<>();

            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                if(t != null) {
                    if(flag)
                        tmp.add(0, t.val);
                    else
                        tmp.add(t.val);
                    next.offer(t.left);
                    next.offer(t.right);
                }
            }

            if(!tmp.isEmpty())
                res.add(tmp);


            flag = !flag;
        }

        return res; 
    }
}
