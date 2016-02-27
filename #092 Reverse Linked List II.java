import java.util.*;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode left = head, right;
        ListNode prev = null, next;

        if(m != 1) {
            for (int i = 2; i < m; i++) {
                left = left.next;
            }
            prev = left;
            left = left.next;
        }
        
        right = left;
        for(int i=0; i<(n-m); i++){
            right = right.next;
        }
        next = right.next;
        
        reverse(left, right, n-m+1);
        
        left.next = next;
        if(prev == null)
            return right;
        else {
            prev.next = right;
            return head;
        }
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
