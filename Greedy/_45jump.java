/**
 * @author wyr on 2025/11/8
 */
public class _45jump {
    public int jump(int[] nums) {
        int n = nums.length;
        int currentEnd = 0;
        int farthest = 0;
        int jump = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == currentEnd){
                jump++;
                currentEnd = farthest;
            }
        }
        return jump;
    }
}
