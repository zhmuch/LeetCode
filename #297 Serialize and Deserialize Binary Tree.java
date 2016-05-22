
//  Time Limit Exceed;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        
        String str = "[";
        Queue<TreeNode> queue;
        Queue<TreeNode> next = new LinkedList<>();
        
        next.offer(root);
        str = str + root.val;
        
        while(!next.isEmpty()){
            queue = next;
            next = new LinkedList<>();

            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                if(t.left == null)
                    str = str + ",null";
                else{
                    str = str + "," + t.left.val;
                    next.offer(t.left);
                }
                if(t.right == null)
                    str = str + ",null";
                else{
                    str = str + "," + t.right.val;
                    next.offer(t.right);
                }
            }
        }

        str = str + "]";
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.length() <= 2)
            return null;
            
        String dataT = data.substring(1, data.length() - 1);
        String[] datas = dataT.split(",");
        
        if(datas[0].equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        
        while(i < datas.length){
            TreeNode tmp = queue.poll();
            
            String t1 = datas[i];
            if(!t1.equals("null")){
                TreeNode t1T = new TreeNode(Integer.parseInt(t1));
                tmp.left = t1T;
                queue.offer(t1T);
            }
            i++;
            
            if(i >= datas.length)
                break;
            else{
                String t2 = datas[i];
                if(!t2.equals("null")){
                    TreeNode t2T = new TreeNode(Integer.parseInt(t2));
                    tmp.right = t2T;
                    queue.offer(t2T);
                }
            }
            i++;
        }

        return root;
    }
}
