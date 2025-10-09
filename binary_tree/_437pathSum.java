import java.util.HashMap;
import java.util.Map;

/**
 * @author wyr on 2025/10/8
 */
public class _437pathSum {
    // Key: 前缀和, Value: 该前缀和出现的次数
    private Map<Long, Integer> prefixSumCount;
    private int target;
    private int totalCount;
    public int pathSum(TreeNode root, int targetSum) {
        prefixSumCount =new HashMap<>();
        target = targetSum;
        totalCount = 0;
        prefixSumCount.put(0L, 1); // 初始化前缀和为0的路径数为1
        dfs(root, 0L);
        return totalCount;
    }
    private void dfs(TreeNode node, long currentSum) {
        if (node == null) {
            return;
        }
        // 1. 更新当前路径的前缀和
        currentSum += node.val;
        // 2. 计算以当前节点为终点的路径中，前缀和为 currentSum - target 的路径数
        totalCount += prefixSumCount.getOrDefault(currentSum - target, 0);
        // 3. 更新前缀和的出现次数
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        // 4. 递归遍历左子树和右子树
        dfs(node.left, currentSum);
        dfs(node.right, currentSum);
        // 5. 回溯：移除当前节点的前缀和，避免影响其他路径的计算
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

    }
}
