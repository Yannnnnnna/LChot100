/**
 * @author wyr on 2025/11/8
 */
public class _55canJump {
    public boolean canJump(int[] nums) {
        int maxLen = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxLen){
                return false;
            }

            maxLen = Math.max(maxLen, i + nums[i]);
            if (maxLen >= nums.length -1){
                return true;
            }

        }
        return true;
    }
}
