import java.util.LinkedList;

/**
 * Created by Muchen on 5/31/16.
 */
public class MinStack {

    LinkedList<Integer> list;
    LinkedList<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        list.add(0, x);
        if(min.size() < 1)
            min.add(0, x);
        else
            min.add(0, Math.min(min.get(0), x));
    }

    public void pop() {
        list.remove(0);
        min.remove(0);
    }

    public int top() {
        return list.get(0);
    }

    public int getMin() {
        return min.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
