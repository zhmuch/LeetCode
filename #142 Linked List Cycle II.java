/*
  o_o_o_o_o_o_o_o_o
      m     |  n  |
            o_o_o_o
  Assume meet at k from cycleStartPoint.
    m + k = x * n (x>=1)  x donates before meet, fast has done x laps.
    then
    m = (n - k) + (x - 1) * n
    So we let fast run for m time at speed of 1, we get to the start point.
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
