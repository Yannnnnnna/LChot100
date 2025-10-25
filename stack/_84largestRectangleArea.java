import java.util.Stack;

/**
 * @author wyr on 2025/10/25
 */
public class _84largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length)? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > h){
                int j = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                res = Math.max(res, (right - left - 1) *heights[j]);

            }
            if (i < heights.length){
                stack.push(i);
            }

        }

        return res;
    }
}
