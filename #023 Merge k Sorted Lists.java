/*
  Divide-Conquer. Recursive. Same as Merge-Sort.
  What about HEAP?
*/

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int l = lists.length;
        ListNode res = null;
        if(l<1)
            return  res;

        res = combine(lists, 0, l-1);

        return res;
    }

    public ListNode combine(ListNode[] lists, int left, int right){
        if(left == right)
            return lists[left];
        
        int mid = (left + right) / 2;
        return merge(combine(lists, left, mid), combine(lists, mid+1, right));
        
    }

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
}

/*
  Straight Forward, merge one by one.
  Time Limit Exceeds.
*/

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int l = lists.length;
        ListNode res = null;
        if(l<1) 
            return  res;
        
        res = lists[0];
        for(int i=1; i<l; i++){
            res = merge(res, lists[i]);
        }
        
        return res;
    }
    
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
}
