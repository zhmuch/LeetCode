/*
  Be Careful.
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;

        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            carry = sum/10;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l;
        if(l1 == null)
            l = l2;
        else
            l = l1;

        if(l == null){
            if(carry != 0){
                curr.next = new ListNode(carry);
            }
        }else{
            while(l != null){
                int sum = l.val + carry;
                curr.next = new ListNode(sum%10);
                curr = curr.next;
                carry = sum/10;
                l = l.next;
            }
            if (carry != 0)
                curr.next = new ListNode(carry);
        }

        return res.next;
    }
}
