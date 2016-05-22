//  Iteratively;
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();  
      
        while(k > 0 && (root != null || !stack.isEmpty())) {
            if(root == null) {
                root = stack.pop();
                k--;
                if(k == 0)
                    return root.val;
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        
        return root.val;
    }
}

//  

//  Inorder Traversal;

public class Solution {
    ArrayList<Integer> res;

    public int kthSmallest(TreeNode root, int k) {
        res = new ArrayList<>();
        inorderTraversal(root);
        return res.get(k - 1);
    }

    private void inorderTraversal(TreeNode root) {
        if(root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
    }
}
