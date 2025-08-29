/**
 * @author wyr on 2025/8/29
 */
public class _240SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // 如果矩阵为空或行列长度为0，直接返回false
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始搜索
        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true; // 找到目标值，返回true
            } else if (matrix[r][c] > target) {
                c--; // 当前值大于目标值，向左移动
            } else {
                r++; // 当前值小于目标值，向下移动
            }
        }
        return false; // 未找到目标值，返回false
    }
}
