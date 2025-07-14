import java.util.Scanner;

/**
 * @author wyr on 2025/7/14
 */
public class _11MaxArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入数组长度
        System.out.print("请输入数组的长度: ");
        int length = in.nextInt();
        // 初始化数组
        int[] height = new int[length];
        // 输入数组元素
        System.out.println("请输入数组元素（每个元素一行）:");
        for (int i = 0; i < length; i++) {
            height[i] = in.nextInt();
        }
        // 调用maxArea方法
        int result = new _11MaxArea().maxArea(height);
        System.out.println(result);
    }
    public int maxArea(int[] height) {
        //容积的计算公式|i-j|*Math.min(height[i], height[j])
        int n = height.length;
        int l = 0, r = n - 1;
        int max = 0;
        while (l != r){
            int area =  (r - l) * Math.min(height[l], height[r]);
            max = Math.max(max, area);
            if(height[l] <= height[r]){
                l++;

            }
            else {
                r--;

            }
        }
        return max;
    }




}
