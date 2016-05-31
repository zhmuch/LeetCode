/**
 * 注意Stack 和 Queue 性质的区别；
 * Queue q1, q2; 如果把q1和q2两个互相交换，得到的两个Queue与原来的相同；
 * Stack s1, s2; 如果把s1和s2互换，得到的两个Stack与原来的元素一样，但是位置不同；栈底-->栈顶，栈顶-->栈底；
 */

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
