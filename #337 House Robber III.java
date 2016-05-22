//  Naive, Recursively;
public class Solution {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        else{
            int exclu = rob(root.left) + rob(root.right);
            
            int inclu = root.val;
            if(root.left != null)
                inclu += rob(root.left.left) + rob(root.left.right);
            if(root.right != null)
                inclu += rob(root.right.left) + rob(root.right.right);
                
            return Math.max(exclu, inclu);
        }
    }
}

//  Nice try
import java.util.*;
 
public class Solution {
    Hashtable<TreeNode, Integer> table = new Hashtable<>();

    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        else{
            int exclu = 0;
            if(root.left != null)
                exclu += table.containsKey(root.left) ? table.get(root.left) : rob(root.left);
            if(root.right != null)    
                exclu += table.containsKey(root.right) ? table.get(root.right) : rob(root.right);

            int inclu = root.val;
            if(root.left != null){
                if(root.left.left != null)
                    inclu += table.containsKey(root.left.left) ? table.get(root.left.left) : rob(root.left.left);
                if(root.left.right != null)
                    inclu += table.containsKey(root.left.right) ? table.get(root.left.right) : rob(root.left.right);
            }
            if(root.right != null){
                if(root.right.left != null)
                    inclu += table.containsKey(root.right.left) ? table.get(root.right.left) : rob(root.right.left);
                if(root.right.right != null)
                    inclu += table.containsKey(root.right.right) ? table.get(root.right.right) : rob(root.right.right);
            }

            return Math.max(exclu, inclu);
        }
    }
}
