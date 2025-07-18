import java.util.HashMap;
import java.util.Map;

/**
 * @author wyr on 2025/7/18
 */
public class _560SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count; // 如果数组为空或长度为0，直接返回0
        }
        int n = nums.length;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // 前1个数前缀和为0
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += nums[i]; // 计算前缀和
            if(prefixSumMap.containsKey(num - k)){
                count += prefixSumMap.get(num - k); // 如果前缀和减去k的值存在，累加对应的次数
            }
            prefixSumMap.put(num, prefixSumMap.getOrDefault(num, 0) + 1); // 更新前缀和的出现次数

        }
        return count; // 返回满足条件的子数组数量
    }
}
