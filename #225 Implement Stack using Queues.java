/**
 *  两个Queue，Stack.pop()相当于取Queue中最后一个；
 */


import java.util.*;

/**
 * Created by Muchen on 5/31/16.
 */
class MyStack {

    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> tmp = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(queue.size() > 1)
            tmp.offer(queue.poll());
        queue.poll();
        
        Queue<Integer> t = tmp;
        tmp = queue;
        queue = t;
    }

    // Get the top element.
    public int top() {
        while(queue.size() > 1)
            tmp.offer(queue.poll());
         
        int getTop = queue.poll();
        tmp.offer(getTop);

        Queue<Integer> t = tmp;
        tmp = queue;
        queue = t;
        
        return getTop;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
