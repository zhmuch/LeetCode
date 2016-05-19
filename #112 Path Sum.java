//  Same as #111;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        else {
            if(root.left == null && root.right == null)
                return (root.val == sum);
            else {
                boolean left = (root.left == null) ? false : hasPathSum(root.left, sum - root.val);
                boolean right = (root.right == null) ? false : hasPathSum(root.right, sum - root.val);
                return left || right;
            }
        }
    }
}
