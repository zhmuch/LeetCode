import java.util.*;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode curr = head, prev = sentinel;

        while(curr != null){
            if(curr.val == val){
                curr = curr.next;
                prev.next = curr;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }

        return sentinel.next;
    }
}
