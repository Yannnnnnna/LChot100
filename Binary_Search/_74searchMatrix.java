/**
 * @author wyr on 2025/10/19
 */
public class _74searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m * n -1;
        while (left <= right){
            int mid_idx = left + (right - left) /2;
            int row = mid_idx / m;
            int col = mid_idx % m;
            int mid = matrix[row][col];
            if (mid < target){
                left = mid_idx + 1;
            }else if (mid > target){
                right = mid_idx -1;
            }else{
                return true;
            }
        }
        return false;
    }
}
