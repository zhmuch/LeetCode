import java.util.*;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null || postorder.length != inorder.length || postorder.length <= 0)
            return null;

        int len = postorder.length;
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for(int i = 0; i < len; i++)
            table.put(inorder[i], i);

        TreeNode root = new TreeNode(postorder[len - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre;

        for(int i = len - 2; i >= 0; i--){
            TreeNode newAdd = new TreeNode(postorder[i]);
            pre = stack.peek();

            if(table.get(postorder[i]) > table.get(pre.val)){
                pre.right = newAdd;
                stack.push(newAdd);
            } else {
                stack.pop();
                if(!stack.isEmpty()){
                    TreeNode prepre = stack.peek();
                    while(table.get(prepre.val) > table.get(postorder[i])){
                        pre = stack.pop();
                        if(!stack.isEmpty())
                            prepre = stack.peek();
                        else
                            break;
                    }
                }
                pre.left = newAdd;
                stack.push(newAdd);
            }
        }
        return root;
    }
}
