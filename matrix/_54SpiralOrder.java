import java.util.ArrayList;
import java.util.List;

/**
 * @author wyr on 2025/8/29
 */
public class _54SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            // 修正点2: 增加边界检查，防止在单行或单列的情况下重复遍历
            if (top <= bottom) {
                // 3. 从右到左
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // 修正点3: 增加边界检查
            if (left <= right) {
                // 4. 从下到上
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
