/*
  先求两链表长。
  长的一方先走，使两个剩余元素数相等。
  再一起走，若有相同元素；则为intersection.
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        int la = 0, lb = 0;
        ListNode sentA = headA;
        ListNode sentB = headB;
        
        while(sentA != null) {
            la++;
            sentA = sentA.next;
        }
        while(sentB != null) {
            lb++;
            sentB = sentB.next;
        }
        
        sentA = headA; 
        sentB = headB;
        if(la > lb)
            for(int i=0; i<la-lb; i++)
                sentA = sentA.next;
        else for(int i=0; i<lb-la; i++)
            sentB = sentB.next;
        
        while(sentA != null){
            if(sentA == sentB)
                return sentA;
            
            sentA = sentA.next;
            sentB = sentB.next;
        }
        
        return null;
    }
}
