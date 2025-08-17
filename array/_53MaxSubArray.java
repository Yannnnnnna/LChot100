/**
 * @author wyr on 2025/8/16
 */
public class _53MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0) {
            return 0; // 如果数组为空或长度为0，直接返回0
        }
        dp[0] = nums[0]; // 初始化第一个元素
        int maxSum = dp[0]; // 初始化最大子数组和为第一个元素
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]); // 状态转移方程
            maxSum = Math.max(maxSum, dp[i]); // 更新最大子数组和
        }
        return maxSum; // 返回最大子数组和


    }
}
