import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wyr on 2025/10/9
 */
public class _994orangesRotting {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        // 统计新鲜橘子数量，并将腐烂橘子的位置加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0) {
            return 0; // 没有新鲜橘子，直接返回0
        }
        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //开始遍历
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean infected = false; // 标记本轮是否有新橘子被感染
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];
                // 四个方向
                for(int[] dir : directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1){
                        grid[newX][newY] = 2; // 感染新橘子
                        freshCount--;
                        queue.offer(new int[]{newX, newY});
                        infected = true; // 有新橘子被感染
                    }
                }

            }
            if (infected) {
                minutes++; // 只有在本轮有新橘子被感染时，才增加分钟数
            }
        }
        return freshCount == 0 ? minutes : -1; // 如果还有新鲜橘子，返回-1
    }
}
