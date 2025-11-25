/**
 * @author wyr on 2025/11/25
 */
public class _37nextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;

        for (int i = len - 2; i >= 0 ; i--) {
            //找到第一个不符合降序的数字
            if (nums[i]  < nums[i + 1]) {
                //找到后面最小的的数字
                for (int j = len - 1; j > i ; j--){
                    if (nums[j] > nums[i]){
                        //交换
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        //反转剩余数字
                        reverse(nums, i + 1, len -1);
                        return;
                    }
                }
            }
        }
        //没找到结果，说明是最大了
            reverse(nums, 0, len -1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
