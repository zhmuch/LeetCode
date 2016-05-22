public class Solution {
    LinkedList<String> res;
    
    public List<String> binaryTreePaths(TreeNode root) {
        res = new LinkedList<>();
        if(root != null){
            String str = "" + root.val;
            if(root.left == null && root.right == null)
                res.add(str);
            dfs(root.left, str);
            dfs(root.right, str);
        }
        return res;
    }
    
    private void dfs(TreeNode root, String str) {
        if(root == null)
            return;
        else {
            String tmp = str + "->" + root.val;
            if(root.left == null && root.right == null)
                res.add(tmp);
            else{
                dfs(root.left, tmp);
                dfs(root.right, tmp);
            }
        }
    }
}
