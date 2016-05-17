//  Be familiar with Preorder & Inorder Traversal
//  Use Stack to keep track of added TreeNodes
//  Hashtable(from Inorder Traversal) store the relative order of TreeNodes 

import java.util.*;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length || preorder.length <= 0)
            return null;

        int len = preorder.length;
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for(int i = 0; i < len; i++)
            table.put(inorder[i], i);

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre;

        for(int i = 1; i < len; i++){
            TreeNode newAdd = new TreeNode(preorder[i]);
            pre = stack.peek();
            
            if(table.get(preorder[i]) < table.get(pre.val)){
                pre.left = newAdd;
                stack.push(newAdd);
            } else {
                stack.pop();
                if(!stack.isEmpty()){
                    TreeNode prepre = stack.peek();
                    while(table.get(prepre.val) < table.get(preorder[i])){
                        pre = stack.pop();
                        if(!stack.isEmpty())
                            prepre = stack.peek();
                        else
                            break;
                    }
                }
                pre.right = newAdd;
                stack.push(newAdd);
            }
        }
        return root;
    }
}
