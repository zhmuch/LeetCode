/*
  Be careful with prev node. Needed to be updated when loop end.
*/

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode op, res, prev, next;
        res = head;
        if(head == null || head.next == null) return res;

        next = head.next.next;
        res = head.next;
        res.next = head;
        prev = head;

        op = next;
        if(op == null) {
            prev.next = op;
            return res;
        }

        while(op != null && op.next != null){
            next = op.next.next;
            prev.next = op.next;
            prev.next.next = op;

            prev = op;
            op = next;
        }
        prev.next = op;

        return res;
    }
}
