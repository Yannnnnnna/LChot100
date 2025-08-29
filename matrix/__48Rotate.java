/**
 * @author wyr on 2025/8/29
 */
public class __48Rotate {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        //1.对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //2. 左右翻转
        for (int i = 0; i <n; i++){
            int l = 0, r= n -1;
            while (l < r){
                int tmp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = tmp;
                l++;
                r--;
            }
        }
    }
}
