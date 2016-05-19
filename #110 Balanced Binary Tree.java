import java.util.*;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return (maxDepth(root) >= 0);
    }

    private int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            // System.out.println("root: " + root.val);
            // System.out.println("left: " + left);
            // System.out.println("right: " + right);
            if(left < 0 || right < 0)
                return -1;
            else
                return (Math.abs(left - right) <= 1) ? Math.max(left, right) + 1 : -1;
        }
    }
}
