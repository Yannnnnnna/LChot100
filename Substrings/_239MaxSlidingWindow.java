import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wyr on 2025/8/11
 */
public class _239MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0) {
            return new int[0]; // 如果数组为空或窗口大小为0，直接返回空数组
        }
        int[] res = new int[n - k + 1]; // 结果数组，存储每个窗口的最大值
        Deque<Integer> deque = new ArrayDeque<>(); // 双端队列，存储窗口内的元素索引
        for (int i = 0; i < n; i++) {
            //把当前元素的索引加入双端队列前，先把比当前元素小的都移除
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            //检查队列头部的元素是否已经滑出窗口
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i); // 将当前元素的索引加入队列

            //取最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()]; // 窗口形成后，记录当前窗口的最大值
            }

        }
        return res;
    }
}
