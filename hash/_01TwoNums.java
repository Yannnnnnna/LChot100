import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _01TwoNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组长度
        System.out.print("请输入数组的长度: ");
        int length = scanner.nextInt();

        // 初始化数组
        int[] nums = new int[length];

        // 输入数组元素
        System.out.println("请输入数组元素:");
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        // 输入目标值
        System.out.print("请输入目标值 target: ");
        int target = scanner.nextInt();

        // 调用twoSum方法
        int[] result = twoSum(nums, target);

        // 输出结果
        if (result != null) {
            System.out.println("结果索引: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("未找到符合条件的两个数");
        }

        scanner.close(); // 关闭输入流

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if(m.containsKey(minus)){
                result[0] = m.get(minus);
                result[1] = i;
                return result;
            }
            m.put(nums[i], i);
        }
        return null;
    }
}