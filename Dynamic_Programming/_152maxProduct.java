import java.util.Arrays;

/**
 * @author wyr on 2025/11/10
 */
public class _152maxProduct {
    public int maxProduct(int[] nums) {
       int currMax = nums[0]; //以上一个元素结尾的最大乘积
        int currMin = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int tmpMax = currMax;
            currMax = Math.max(n, Math.max(currMax * n, currMin * n));
            currMin = Math.min(n, Math.min(tmpMax * n, currMin * n));
            globalMax = Math.max(globalMax, currMax);

        }
        return globalMax;
    }
}
