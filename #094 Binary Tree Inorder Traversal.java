/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Recursive Edition
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderRecur(root);
    }

    public List<Integer> inorderRecur(TreeNode curr){
        List<Integer> result = new ArrayList<>();
        if (curr == null) return result;

        List<Integer> left;
        List<Integer> right;

        left = inorderTraversal(curr.left);
        right = inorderTraversal(curr.right);

        result.addAll(left);
        result.add(curr.val);
        result.addAll(right);

        return result;
    }
}
