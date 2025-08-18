/**
 * @author wyr on 2025/8/18
 */
public class _238ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0]; // 如果数组为空或长度为0，直接返回空数组
        }
        int n = nums.length;
        int[] result = new int[n]; // 结果数组，存储每个位置的乘积
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1]; // 前缀积
        }
        int suffix = 1; // 后缀积
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix; // 当前结果乘以后缀积
            suffix *= nums[i]; // 更新后缀积
        }
        return result; // 返回结果数组
    }
}
