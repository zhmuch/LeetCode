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

//  Other`s Queue;
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode current = queue.poll();
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
    }
    return root;
}
