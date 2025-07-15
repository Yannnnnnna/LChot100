import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author wyr on 2025/7/15
 */
public class _42Trap {
    public static void main(String[] args) {
        // 示例：测试 threeSum 方法
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整数数组（用空格分隔）：");
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        // 调用目标方法（示例为 threeSum）
        int result = new _42Trap().trap(nums);

        // 输出结果
        System.out.println("结果：" + result);
    }
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
           //判断当前元素是否大于栈顶
            //大于栈顶元素，说明可以计算雨水，进行计算
            //计算完成弹出栈顶
            // 维护单调递减栈
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // 凹槽底部
                if (stack.isEmpty()) continue; // 无左边界
                int l = stack.peek(); // 左边界
                // 计算凹槽的宽度和高度差
                ans += (Math.min(height[l], height[i]) - height[top])
                        * (i - l - 1);
            }
            stack.push(i);
        }
        return ans;
    }
}
