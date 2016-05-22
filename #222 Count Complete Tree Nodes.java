//  Little improvement;
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
            
        int leftH = 1;
        TreeNode tmpL = root;
        while(tmpL.left != null){
            leftH++;
            tmpL = tmpL.left;
        }
        
        int rightH = 1;
        TreeNode tmpR = root;
        while(tmpR.right != null){
            rightH++;
            tmpR = tmpR.right;
        }
        
        if(leftH == rightH)
            return ((int)Math.pow(2, leftH)) - 1;           //  Slow
            return (2 << (leftH - 1)) - 1;                  //  Quick!!!
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

//  Native;
public class Solution {
    public int countNodes(TreeNode root) {
        return (root == null) ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
