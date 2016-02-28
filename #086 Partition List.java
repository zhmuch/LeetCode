import java.util.*;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode sentL, sentR;
        sentL = new ListNode(0);
        sentL.next = null;
        sentR = new ListNode(0);
        sentR.next = null;

        ListNode left = sentL, right = sentR;
        ListNode curr = head, next;

        while(curr != null){
            next = curr.next;
            if(curr.val < x){
                left.next = curr;
                left = curr;
            }
            else{
                right.next = curr;
                right = curr;
            }
            curr = next;
        }
        right.next = null;
        left.next = sentR.next;
        return sentL.next;
    }
}
