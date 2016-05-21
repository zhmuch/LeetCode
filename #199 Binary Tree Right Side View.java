public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> next = new LinkedList<>();
        LinkedList<TreeNode> curr;
        List<Integer> res = new LinkedList<>();
        
        if(root != null)
            next.add(root);
            
        while(!next.isEmpty()){
            curr = next;
            next = new LinkedList<>();
            int add = 0;
            for(TreeNode t : curr){
                add = t.val;
                if(t.left != null)
                    next.add(t.left);
                if(t.right != null)
                    next.add(t.right);
            }
            res.add(add);
        }
        
        return res;
    }
}
