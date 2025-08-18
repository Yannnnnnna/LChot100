

/**
 * @author wyr on 2025/8/18
 */
public class _41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int n = nums.length;

        // --- 第一步：原地哈希 ---
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // --- 第二步：查找第一个不匹配的位置 ---
        for (int i = 0; i < n; i++) {
            // 找到后立刻返回
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 修正点 3：处理所有数字都存在的情况 ***
        return n + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
