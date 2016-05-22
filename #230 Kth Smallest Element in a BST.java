//  Inorder Traversal;

public class Solution {
    ArrayList<Integer> res;

    public int kthSmallest(TreeNode root, int k) {
        res = new ArrayList<>();
        inorderTraversal(root);
        return res.get(k - 1);
    }

    private void inorderTraversal(TreeNode root) {
        if(root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
    }
}
