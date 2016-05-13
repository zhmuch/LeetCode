//  Time Limit Exceed.

public class Solution {
    public boolean isValidBST(TreeNode root) {

        if(root == null)
            return true;
        
        return (isValid(root)[0] == 1);
                
    }
    
    private int[] isValid(TreeNode root) {
        
        //  0: flag     1: Min      2: Max
        int[] res = new int[3];

        if(root.left == null && root.right == null){
            res[0] = 1;
            res[1] = res[2] = root.val;
        }

        if(root.left != null && root.right != null){
            int[] left = isValid(root.left);
            int[] right = isValid(root.right);
            res[0] = (left[0] == 1 && right[0] == 1 && left[2] < root.val && right[1] > root.val) ? 1 : 0;
            res[1] = left[1];
            res[2] = right[2];
        }
        
        if(root.left != null){
            int[] left = isValid(root.left);
            res[0] = (left[0] == 1 && left[2] < root.val) ? 1 : 0;
            res[1] = left[1];
            res[2] = root.val;
        }

        if(root.right != null){
            int[] right = isValid(root.right);
            res[0] = (right[0] == 1 && right[1] > root.val) ? 1 : 0;
            res[1] = root.val;
            res[2] = right[2];
        }
        
        return res;
        
    }
}
