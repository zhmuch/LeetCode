//  Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root != null) {
            TreeNode tmp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = tmp;
        }
        return root;
    }
}
