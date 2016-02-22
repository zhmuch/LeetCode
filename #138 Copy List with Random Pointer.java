import java.util.*;


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        int size = 0;

        RandomListNode res = new RandomListNode(head.label);
        RandomListNode rcurr = res;

//        Hashtable<RandomListNode, Integer> origin = new Hashtable<>();
//        Hashtable<Integer, RandomListNode> copied = new Hashtable<>();
//        origin.put(head, size);
//        copied.put(size, res);
        Hashtable<RandomListNode, RandomListNode> hash = new Hashtable<>();
        hash.put(head, res);
        
        RandomListNode curr = head.next;
        while(curr != null){
            size++;

            rcurr.next = new RandomListNode(curr.label);
            rcurr = rcurr.next;
            hash.put(curr, rcurr);
            curr = curr.next;
        }

        curr = head;
        rcurr = res;
        while(curr != null){
            if (curr.random != null) {
                rcurr.random = hash.get(curr.random);
            }
            else rcurr.random = null;
            curr = curr.next;
            rcurr = rcurr.next;
        }

        return res;
    }
}
