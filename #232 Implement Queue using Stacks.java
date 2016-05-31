import java.util.Stack;

/**
 * Created by Muchen on 5/31/16.
 */
class MyQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tmp = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!stack.isEmpty())
            tmp.push(stack.pop());
        
        tmp.pop();
        
        while(!tmp.isEmpty())
            stack.push(tmp.pop());
    }

    // Get the front element.
    public int peek() {
        while(!stack.isEmpty())
            tmp.push(stack.pop());

        int p = tmp.peek();

        while(!tmp.isEmpty())
            stack.push(tmp.pop());
        
        return p;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
