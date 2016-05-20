//  Same as #116;

public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue;
        Queue<TreeLinkNode> next = new LinkedList<>();

        if(root != null)
            next.offer(root);

        while(!next.isEmpty()){
            queue = next;
            next = new LinkedList<>();

            if(queue.size() > 1){
                TreeLinkNode pre = queue.poll();
                if(pre.left != null)
                    next.offer(pre.left);
                if(pre.right != null)
                    next.offer(pre.right);

                while(!queue.isEmpty()){
                    TreeLinkNode t = queue.poll();
                    pre.next = t;
                    if(t.left != null)
                        next.offer(t.left);
                    if(t.right != null)
                        next.offer(t.right);
                    pre = t;
                }
            } else {
                TreeLinkNode t = queue.poll();
                if(t.left != null)
                        next.offer(t.left);
                if(t.right != null)
                        next.offer(t.right);
            }
        }

        return;
    }
}
