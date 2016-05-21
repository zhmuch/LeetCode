public class Solution {
    
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        sumDFS(root, 0);
        return sum;
    }
    
    private void sumDFS(TreeNode root, int pre) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            sum += pre * 10 + root.val;
        else {
            pre = pre * 10 + root.val;
            sumDFS(root.left, pre);
            sumDFS(root.right, pre);
        }
    }
}
