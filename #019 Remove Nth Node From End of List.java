import java.util.*;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0)
            return head;

        ListNode curr = head, target = head, prev = null;
        for(int i=1; i<n; i++)
            curr = curr.next;

        while(curr.next != null){
            curr = curr.next;
            prev = target;
            target = target.next;
        }

        if(prev == null) {
            return target.next;
        }
        else{
            prev.next = target.next;
        }

        return head;
    }
}
