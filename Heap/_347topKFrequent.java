import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wyr on 2025/11/3
 */
public class _347topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.offer(entry);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()){
            result[i] = minHeap.poll().getKey();
            i++;
        }
        return result;
    }
}
