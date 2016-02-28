import java.util.*;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        boolean mx = true;
        ListNode sentO = new ListNode(0), sentE = new ListNode(0);
        ListNode odd = sentO, even = sentE;
        ListNode curr = head;

        while(curr != null){
            if(mx){
                odd.next = curr;
                odd = curr;
            }
            else {
                even.next = curr;
                even = curr;
            }
            mx = !mx;
            curr = curr.next;
        }
        
        even.next = null;
        odd.next = sentE.next;
        return sentO.next;
    }
}
