import java.util.*;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tmp = head;
        int l = 1;
        while(tmp.next != null){
            tmp = tmp.next;
            l++;
        }
        ListNode tail = tmp;

        k = l - (k % l);
        if(k == l)
            return head;

        tmp = head;
        for(int i=1; i<k; i++){
            tmp = tmp.next;
        }
        ListNode ntail = tmp;
        tmp = tmp.next;

        tail.next = head;
        head = tmp;
        ntail.next = null;
        return head;
    }
}
