import java.util.*;

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
            return;

        ListNode left = head, right = head;
        int count = 0;
        while(right.next != null && right.next.next != null){
            left = left.next;
            right = right.next.next;
            count++;
        }
        if(right.next != null)
            left = left.next;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = left.next;
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        
        curr = head;
        ListNode next = head.next;
        for(int i=0; i<count; i++){
            ListNode tmp = stack.pop();
            curr.next = tmp;
            tmp.next = next;
            curr = next;
            next = next.next;
        }
        left.next = null;
    }
}
