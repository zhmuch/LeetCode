public class Solution {
    int sum;

    public int maxPathSum(TreeNode root) {
        
        sum = root.val;
        maxDFS(root);
        
        return sum;
    }

    private int maxDFS(TreeNode root){
        if(root == null)
            return 0;

        int left = maxDFS(root.left);
        int right = maxDFS(root.right);

        sum = Math.max(left + right + root.val, sum);

        int cont = Math.max(left, right) + root.val;

        return (cont > 0) ? cont : 0;
    }
}
