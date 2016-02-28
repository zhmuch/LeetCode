import java.util.*;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode curr, done;
        ListNode sentinel = new ListNode(0);

        done = sentinel;
        curr = head;
        int val = head.val;

        while(curr.next != null){
            if(curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                if(curr.next == null){
                    done.next = null;
                    return sentinel.next;   //exit when last element is duplicate
                }
                else{
                    curr = curr.next;
                }
            }
            else{
                done.next = curr;
                done = curr;
                curr = curr.next;
            }
        }
        done.next = curr;
        return sentinel.next;               //exit when last element is not duplicate
    }
}
