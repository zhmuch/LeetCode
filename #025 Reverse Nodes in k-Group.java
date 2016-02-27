import java.util.*;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode sentinel = new ListNode(-1);
        if(k<2) return head;
        if(head == null) return head;

        ListNode left;
        ListNode right;
        ListNode prev;
        ListNode next;

        left = head;
        right = head;

        for (int i = 1; i < k; i++) {
            right = right.next;
            if (right == null){
                return head;
            }
        }
        next = right.next;
        reverse(left, right, k);
        left.next = null;
        head = right;
        prev = left;
        left = next;
        right = next;

        while(right != null) {
            for (int i = 1; i < k; i++) {
                right = right.next;
                if (right == null){
                    prev.next = left;
                    return head;
                }
            }
            next = right.next;

            reverse(left, right, k);
            left.next = null;
            prev.next = right;

            prev = left;
            left = next;
            right = next;
        }
        return head;
    }

    public void reverse(ListNode a, ListNode b, int k){
        ListNode op = a.next;
        ListNode prev = a;
        ListNode next;

        for(int i=1; i<k; i++){
            next = op.next;
            op.next = prev;
            prev = op;
            op = next;
        }

        return;
    }
}
