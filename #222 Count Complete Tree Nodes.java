//  Native;
public class Solution {
    public int countNodes(TreeNode root) {
        return (root == null) ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
