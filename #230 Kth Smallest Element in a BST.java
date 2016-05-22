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

//  Recursively;
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int left = count(root.left);
        
        if(k <= left)
            return kthSmallest(root.left, k);
        else if (k == left + 1)
            return root.val;
        else
            return kthSmallest(root.right, k - left - 1);
    }
    
    private int count(TreeNode root) {
        return (root == null) ? 0 : count(root.left) + count(root.right) + 1;
    }
}

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
