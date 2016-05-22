//  Naive, Recursively;
public class Solution {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        else{
            int exclu = rob(root.left) + rob(root.right);
            
            int inclu = root.val;
            if(root.left != null)
                inclu += rob(root.left.left) + rob(root.left.right);
            if(root.right != null)
                inclu += rob(root.right.left) + rob(root.right.right);
                
            return Math.max(exclu, inclu);
        }
    }
}
