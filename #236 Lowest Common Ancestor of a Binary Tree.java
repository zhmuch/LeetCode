
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
