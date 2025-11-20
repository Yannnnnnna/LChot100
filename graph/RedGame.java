import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author wyr on 2025/11/12
 * 链接：https://ac.nowcoder.com/acm/problem/229960
 * 来源：牛客网
 *
 * 小红正在玩一个游戏。游戏的地图是一个n*m的迷宫，迷宫有墙和道路，道路上可能会有一些怪物。
 * 小红初始的血量是
 * ℎ
 * h ，每当小红经过一个有怪物的道路时，小红就会和怪物战斗，击杀怪物并且消耗自己的血量。小红消耗的血量等同于该怪物的战斗力。请注意，如果小红血量为0则死亡。因此只有当小红当前血量大于怪物的战斗力时才可经过该点。
 * 地图共有以下几种标识：
 * '.' 代表道路，小红可以经过。
 * '*' 代表墙体，小红不能经过。
 * '1'~'9' 数字，代表该位置是个道路，且上面有一个战斗力为该数字的怪物。
 * 小红只可以上下左右四个方向移动。
 * 小红想知道，自己从左上角到右下角的最短行走路线的距离是多少？
 */
public class RedGame {
    static class State{
        int x;
        int y;
        int health;
        State(int x, int y, int health){
            this.health = health;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int h = in.nextInt();
        in.nextLine(); // <-- 添加这一行，消耗掉nextInt()留下的换行符
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = in.nextLine().toCharArray();
        }
        //定义dist数组,初始化为-1
        int[][][] dist = new int[n][m][h + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        //定义队列
        Queue<State> queue = new LinkedList<>();
        //添加起始状态
        queue.offer(new State(0,0, h));
        dist[0][0][h] = 0;
        //方向
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while (!queue.isEmpty()){
            State cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;
            int ch = cur.health;
            int steps = dist[cx][cy][ch];
            //遍历四个方向查找下一步
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                //边界检查
                if(nx < 0 || ny < 0 || nx>=n||ny>=m){
                    continue;
                }
                int cell = map[nx][ny];
                //墙
                if (cell == '*'){
                    continue;
                }
                //路
                if (cell == '.'){
                    if (dist[nx][ny][ch] == -1){
                        dist[nx][ny][ch] = steps + 1;
                        queue.offer(new State(nx,ny,ch));
                    }
                }
                //怪兽
                else if(Character.isDigit(cell)){
                    int power = Character.getNumericValue(cell);
                    if (ch > power){
                        int newPower = ch -power;
                        if (dist[nx][ny][newPower] == -1){
                            dist[nx][ny][newPower] = steps + 1;
                            queue.offer(new State(nx,ny,newPower));
                        }
                    }
                }
            }
        }
        int minStep = Integer.MAX_VALUE;
        //查找答案
        for (int i = 0; i <= h; i++) {
            if(dist[n-1][m-1][i] != -1){
                minStep = Math.min(minStep, dist[n-1][m-1][i]);
            }
        }
        //输出结果
        if (minStep == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(minStep);
        }
    }
}
