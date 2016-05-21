public class Solution {
    
    List<Integer> res = new LinkedList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderDFS(root);
        return res;
    }
    
    private void preorderDFS(TreeNode root) {
        if(root != null){
            res.add(root.val);
            preorderDFS(root.left);
            preorderDFS(root.right);
        }
    }
}
