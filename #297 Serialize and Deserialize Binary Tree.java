
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


//  Other`s 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return firstRoot(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String [] fs = data.split(",");
        Stack<TreeNode> space = new Stack<TreeNode>();
        int state = 0;
        TreeNode root = null;
        for (int i = 0; i < fs.length; i++) {
            TreeNode node = null;
            if (state == 0) {
                if (!fs[i].equals("#")) {
                    node = new TreeNode(Integer.parseInt(fs[i]));
                    if (!space.isEmpty()) {
                        TreeNode lastNode = space.peek();
                        lastNode.left = node;
                    }
                    space.push(node);
                } else {
                    state = 1;
                }
            } else if (state == 1) {
                if (!fs[i].equals("#")) {
                    node = new TreeNode(Integer.parseInt(fs[i]));
                    if (!space.isEmpty()) {
                        TreeNode lastNode = space.peek();
                        lastNode.right = node;
                    }
                    state = 0;
                    space.push(node);
                } else {
                    TreeNode lastNode = space.pop();
                    while (!space.isEmpty() && space.peek().right == lastNode) {
                        lastNode = space.pop();
                    }
                }
            }
            if (root == null) root = node;
        }
        return root;
    }

    public String firstRoot(TreeNode root) {
        if (root == null) return "";
        StringBuffer sb = new StringBuffer("");
        Stack<TreeNode> space = new Stack<TreeNode>();
        space.push(root);
        while (!space.isEmpty()) {
            TreeNode node = space.pop();
            if (node.val != Integer.MIN_VALUE) {
                sb.append(sb.length() == 0 ? node.val : "," + node.val);
                if (node.right != null) {
                    space.push(node.right);
                } else {
                    space.push(new TreeNode(Integer.MIN_VALUE));
                }

                if (node.left != null) {
                    space.push(node.left);
                } else {
                    space.push(new TreeNode(Integer.MIN_VALUE));
                }
            } else {
                sb.append(sb.length() == 0 ? "#" : ",#");
            }
        }
        return sb.toString();
    }

    public void firstRoot(TreeNode root, int sign) {
        if (root == null) return;
        Stack<TreeNode> space = new Stack<TreeNode>();
        space.push(root);
        while (!space.isEmpty()) {
            TreeNode node = space.pop();
            System.out.println(node.val);
            if (node.right != null) space.push(node.right);
            if (node.left != null) space.push(node.left);
        }
    }
}
