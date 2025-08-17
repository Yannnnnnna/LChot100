import java.lang.reflect.Array;



/**
 * @author wyr on 2025/8/17
 */
public class _189Rotate {
    public void rotate(int[] nums, int k) {
        // 如果数组为空或只有一个元素，无需旋转
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;
        // 步骤 0: 规范化 k
        // 如果 k 大于数组长度，实际旋转的次数是 k % n
        // 例如，长度为7的数组，旋转7次等于没旋转，旋转8次等于旋转1次
        k %= n;
        reverse(nums, 0, n - 1); // 反转整个数组
        reverse(nums, 0, k-1);
        reverse(nums, k, n - 1);
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
