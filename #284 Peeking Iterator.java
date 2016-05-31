/**
 * 用一个flag 和 int; 表示当前元素是不是被peek过；
 * 如果peeked
 *      返回该缓存int
 * 如果未peeked
 *      按一般迭代器操作
 */

/**
 * Created by Muchen on 5/31/16.
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    boolean flag;
    int tmp;


    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        flag = false;
        tmp = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!flag){
            tmp = next();
            flag = true;
        }
        return tmp;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(flag){
            flag = false;
            return tmp;
        } else
            return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return flag || iterator.hasNext();
    }
}
