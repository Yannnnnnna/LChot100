

/**
 * @author wyr on 2025/7/14
 */
public class _283MoveZeroes {
    public void moveZeroes(int[] nums) {
       if(nums == null || nums.length == 0) {
           return; // 如果数组为空或长度为0，直接返回
       }
       int n = nums.length, l = 0, r = 0;
       while (r < n){
           if(nums[r] != 0){
               swap(nums,l,  r);
               ++l;
           }
           ++r;
       }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
