//  Iteratively;    
//  Tricky one: using preorder traversal;
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp == null)
                continue;
            else{
                res.add(tmp.val);
                stack.push(tmp.left);
                stack.push(tmp.right);
            }
        }
        
        List<Integer> rev = new LinkedList<>();
        for(int i : res)
            rev.add(0, i);
            
        return rev;
    }
}

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
