import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Muchen on 5/1/16.
 */
class MedianFinder {

    private double median;

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {

        //  Add a number to either of the Heaps;
        if(maxHeap.size() == 0 && minHeap.size() == 0)
            minHeap.offer(num);
        else if(minHeap.peek() < num)
            minHeap.offer(num);
        else
            maxHeap.offer(num);

        //  Balance the two Heaps;
        if(Math.abs(minHeap.size() - maxHeap.size()) > 1)
            if(minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());
            else
                minHeap.offer(maxHeap.poll());

        //  Update the Median value;
        if(minHeap.size() == maxHeap.size()) {
            if (minHeap.size() == 0)
                median = 0.0;
            else
                median = ((double)(minHeap.peek() + maxHeap.peek())) / 2;
        } else
            median = (minHeap.size() > maxHeap.size()) ? minHeap.peek() : maxHeap.peek();

    }

    // Returns the median of current data stream
    public double findMedian() {
        return median;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
