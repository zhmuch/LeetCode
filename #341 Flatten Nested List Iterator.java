import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
 
 //   Recursion Version!!!!!!!!!!!!!!!
 
 
public class NestedIterator implements Iterator<Integer> {

    LinkedList<Integer> list;
    Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>();

        for(NestedInteger i : nestedList)
            for(Integer j : iterate(i))
                list.add(j);

        iterator = list.iterator();
    }

    private List<Integer> iterate(NestedInteger n) {
        LinkedList<Integer> res = new LinkedList<>();

        if(n.isInteger())
            res.add(n.getInteger());
        else
            for(NestedInteger i : n.getList())
                for(Integer j : iterate(i))
                    res.add(j);

        return res;
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
