import java.util.Arrays;



/**
 * @author wyr on 2025/11/24
 */
public class _75sortColors {
    //荷兰国旗问题
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0, cur = 0, p1 = len-1;
        while (cur <= p1){
            if (nums[cur] == 0){
                swap(nums, cur, p0);
                p0++;
                cur++;
            } else if (nums[cur] == 1) {
                cur++;
            }else if (nums[cur] ==2){
                swap(nums,cur, p1);
                p1--;
            }
        }
    }

    private void swap(int[] nums, int x1, int x2) {
        int tmp = nums[x1];
        nums[x1] = nums[x2];
        nums[x2] = tmp;
    }
}
