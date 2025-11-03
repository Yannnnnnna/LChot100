import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author wyr on 2025/11/3
 */
public class MedianFinder {
    private PriorityQueue<Integer> minHeap; //较大一半
    private PriorityQueue<Integer> maxHeap; //较小一般
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() < maxHeap.size()){
            return maxHeap.peek();
        }
        else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
