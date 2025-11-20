/**
 * @author wyr on 2025/11/20
 */
public class _416canPartition {
    public boolean canPartition(int[] nums) {
        int total = 0;
        int len = nums.length;
        for (int num : nums) {
            total += num;
        }
        if(total % 2 != 0){
            return false;
        }
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--){
                dp[i] = dp[i] || dp[i - num];
            }

        }

        return dp[target];
    }
}
