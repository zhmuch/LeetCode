import java.util.*;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2 == null)
            return l1;
        if(l1 == null)
            return l2;
        
        ListNode sentinel = new ListNode(0);
        ListNode done = sentinel;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                done.next = l1;
                done = l1;
                l1 = l1.next;
            }
            else{
                done.next = l2;
                done = l2;
                l2 = l2.next;
            }
        }
        if(l1 == null)
            done.next = l2;
        else
            done.next = l1;
        
        return sentinel.next;
    }
}
