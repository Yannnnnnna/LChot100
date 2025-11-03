import java.util.PriorityQueue;

/**
 * @author wyr on 2025/11/3
 */
public class _215findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num: nums){
            heap.offer(num);
            if (heap.size()  > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}
