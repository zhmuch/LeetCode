/*
  AC.  Modified merge method.
*/
import java.util.*;

    public ListNode merge(ListNode a, ListNode b){
        if(a == null)
            return b;
        if(b == null)
            return a;

        ListNode res = null, prev = null;
        if(a.val < b.val) {
            res = a;
            prev = a;
            a = a.next;
        }
        else {
            res = b;
            prev = b;
            b = b.next;
        }

        while(a != null && b != null){
            if(a.val < b.val){
                prev.next = a;
                prev = prev.next;
                a = a.next;
            }
            else{
                prev.next = b;
                prev = prev.next;
                b = b.next;
            }
        }

        if(a == null)
            prev.next = b;
        else
            prev.next = a;
        return res;
    }

/*
  java.lang.StackOverflowError  Line29, Line31
*/

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode curr){
        if(curr == null || curr.next == null) return curr;

        ListNode mid = findMid(curr);
        ListNode first = curr, second = mid.next;
        mid.next = null;

        return merge(mergeSort(first), mergeSort(second));
    }

    public ListNode merge(ListNode a, ListNode b){
        if(a == null)
            return b;
        else if(b == null)
            return a;
        else if(a.val < b.val)
            return insertBack(a, merge(a.next, b));
        else
            return insertBack(b, merge(a, b.next));
    }

    public ListNode insertBack(ListNode prev, ListNode post){
        prev.next = post;
        return prev;
    }

    public ListNode findMid(ListNode curr){
        ListNode slow = curr, fast = curr;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
