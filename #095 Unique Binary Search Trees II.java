import java.util.*;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        if(n < 1)
            return new LinkedList<>();
        
        return gen(1, n);
        
    }

    public LinkedList<TreeNode> gen(int left, int right) {
        
        LinkedList<TreeNode> res = new LinkedList<>();

        if(left > right)
            res.add(null);
        else {
            for(int i = left; i <= right; i++){
                
                LinkedList<TreeNode> lefts = gen(left, i - 1);
                LinkedList<TreeNode> rights = gen(i + 1, right);
                
                for(TreeNode j : lefts)
                    for(TreeNode k : rights){
                        TreeNode tmpRoot = new TreeNode(i);
                        tmpRoot.left = j;
                        tmpRoot.right = k;
                        res.add(tmpRoot);
                    }
            }
            
        }
        
        return res;
    }

}
