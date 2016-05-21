//  Recursively;
public class Solution {
    
    List<Integer> res = new LinkedList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        postorderDFS(root);
        return res;
    }
    
    private void postorderDFS(TreeNode root) {
        if(root != null){
            postorderDFS(root.left);
            postorderDFS(root.right);
            res.add(root.val);
        }
    }
}
