import java.util.*;

public class Solution {
    private TreeNode pre = null, left = null, right = null;

    public void recoverTree(TreeNode root) {

        inOrderTraverse(root);

        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;

        return;
    }

    private void inOrderTraverse(TreeNode root) {

        // Traverse the tree in inorder.
        if (root != null) {

            // Inorder traversal: left first.
            inOrderTraverse(root.left);

            // Compare it with the previous value in inorder traversal.
            if (pre != null && pre.val > root.val) {
                if (left == null){
                    left = pre;
                    right = root;
                } else 
                    right = root;
            }
            
            // Update the previous value.
            pre = root;

            // Inorder traversal: right last.
            inOrderTraverse(root.right);

        }
        return;
    }
}
