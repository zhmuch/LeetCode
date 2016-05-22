//  Much better;
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        return (left == null) ? right : (right == null) ? left : root;
    }
}

//  Naive;
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q)
            return root;
        else{
            boolean leftP = contain(root.left, p);
            boolean leftQ = contain(root.left, q);
            
            if(leftP && leftQ)
                return lowestCommonAncestor(root.left, p, q);
            else if(!leftP && !leftQ)
                return lowestCommonAncestor(root.right, p, q);
            else
                return root;
        }
    }
    
    private boolean contain(TreeNode root, TreeNode p) {
        if(root == null)
            return false;
        else if(root == p)
            return true;
        else 
            return contain(root.left, p) || contain(root.right, p);
    }
}
