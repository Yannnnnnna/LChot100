import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyr on 2025/8/16
 */
public class _56Merge {
    public int[][] merge(int[][] intervals) {
        // 1. 处理边界情况
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // 2. 按照区间的起始位置排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        // 3. 将第一个区间先加进去作为比较的基准
        merged.add(intervals[0]);

        // 4. 从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            // 从结果列表中取出最后一个合并好的区间
            int[] lastMerged = merged.get(merged.size() - 1);

            // 检查当前区间是否可以和最后一个合并区间合并
            if (currentInterval[0] <= lastMerged[1]) {
                // 可以合并，更新最后一个合并区间的右边界
                lastMerged[1] = Math.max(lastMerged[1], currentInterval[1]);
            } else {
                // 不可合并，将当前区间作为一个新的合并区间添加
                merged.add(currentInterval);
            }
        }

        // 5. 将列表转换为二维数组并返回
        return merged.toArray(new int[merged.size()][]);
    }
}