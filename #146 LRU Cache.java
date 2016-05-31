/**
 * 链表＋HashMap;
 */

import java.util.HashMap;

/**
 * Created by Muchen on 5/31/16.
 */
public class LRUCache {

    int capacity;
    int count;
    Node root;
    Node tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        
        this.root = new Node();
        this.tail = new Node();
        root.next = tail;
        tail.prev = root;
        
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        else {
            Node curr = map.get(key);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            root.next.prev = curr;
            curr.next = root.next;
            root.next = curr;
            curr.prev = root;

            return curr.value;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).value = value;
            get(key);
        } else {
            if(count < capacity) {
                Node curr = new Node(key, value);
                
                root.next.prev = curr;
                curr.next = root.next;
                root.next = curr;
                curr.prev = root;
                
                count++;
                map.put(key, curr);
            } else {
                map.remove(tail.prev.key);
                count--;
                
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                
                set(key, value);
            }
        }
    }

    class Node {

        int key;
        int value;
        Node next;
        Node prev;

        public Node(int k, int v){
            this.key = k;
            this.value = v;
            this.next = null;
            this.prev = null;
        }

        public Node(){}

    }
}
