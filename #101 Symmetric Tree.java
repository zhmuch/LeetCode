import java.util.*;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return symCompare(root.left, root.right);
    }

    private boolean symCompare(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        else if(left != null && right != null)
            return (left.val == right.val) && symCompare(left.left, right.right) && symCompare(left.right, right.left);
        else
            return false;
    }
}
