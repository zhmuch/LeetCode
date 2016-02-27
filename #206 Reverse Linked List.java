import java.util.*;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;

        ListNode tail = head;
        while(tail.next != null)
            tail = tail.next;

        reverse(head).next = null;
        return tail;
    }

    public ListNode reverse(ListNode op){
        if(op.next != null)
            reverse(op.next).next = op;
        return op;
    }
}
