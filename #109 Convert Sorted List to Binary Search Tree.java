import java.util.*;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if(head.next == null){
            return new TreeNode(head.val);
        }
        
        ListNode mid = findMid(head);
        TreeNode res = new TreeNode(mid.next.val);
        ListNode left = head, right = mid.next.next;
        mid.next = null;
        
        res.left = sortedListToBST(left);
        res.right = sortedListToBST(right);
        
        return res;
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; 
    }
}
