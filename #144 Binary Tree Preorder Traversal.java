//  Iteratively;
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp == null)
                continue;
            else{
                res.add(tmp.val);
                stack.push(tmp.right);
                stack.push(tmp.left);
            }
        }
        return res;
    }

}

//  Recursively;
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
