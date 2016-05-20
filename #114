//  Move nodes around;

public class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    private TreeNode dfs(TreeNode root) {
        if(root == null)
            return null;
        else{
            if(root.left == null && root.right == null)
                return root;
            else if(root.left != null && root.right != null){
                TreeNode leftEnd = dfs(root.left);
                TreeNode rightEnd = dfs(root.right);
                
                TreeNode tmp = root.right;
                root.right = root.left;
                root.left = null;
                leftEnd.right = tmp;
                return rightEnd;
            } else if(root.left != null){
                TreeNode leftEnd = dfs(root.left);
                root.right = root.left;
                root.left = null;
                return leftEnd;
            } else {
                TreeNode rightEnd = dfs(root.right);
                return rightEnd;
            }
        }
    }
}
