import java.util.*;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = head, curr = prev.next, next;

        while(curr != null){
            next = curr.next;

            ListNode tprev = sentinel, tmp = tprev.next;
            while(true){
                if(tmp == curr) {
                    prev = curr;
                    break;
                }
                else {
                    if (curr.val > tmp.val) {
                        tmp = tmp.next;
                        tprev = tprev.next;
                    } else {
                        tprev.next = curr;
                        curr.next = tmp;
                        prev.next = next;
                        break;
                    }
                }
            }
            curr = next;
        }

        return sentinel.next;
    }
}
