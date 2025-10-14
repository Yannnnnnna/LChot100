import java.util.*;

/**
 * @author wyr on 2025/10/14
 */
public class _209canFinish {
//    //深度遍历+标记数组
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<List<Integer>> map = new ArrayList<>();
//        for (int i = 0; i < numCourses; i++) {
//            map.add(new ArrayList<>());
//        }
//        for (int[] p : prerequisites){
//            map.get(p[1]).add(p[0]);
//        }
//        //0 未访问 1访问中 2已访问
//        int[] visited = new int[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            if (visited[i] == 0) {
//                if (hasCycle(i, map, visited)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//
//    }
//
//    private boolean hasCycle(int i, List<List<Integer>> map, int[] visited) {
//        visited[i] = 1;
//        for (int next : map.get(i)) {
//            if (visited[next] == 1) {
//                return true;
//            } else if (visited[next] == 0){
//                if (hasCycle(next, map, visited)) {
//                    return true;
//                }
//            }
//        }
//        visited[i] = 2;
//        return false;
//    }


    //拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        int[] indo = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] p : prerequisites){
            map.get(p[1]).add(p[0]);
            indo[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indo[i] == 0){
                queue.add(i);
            }
        }
        int finish = 0;
        while (!queue.isEmpty()){
            int cur =  queue.poll();
            ++finish;
            for (int next :
                    map.get(cur)) {
                indo[next]--;
                if (indo[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return finish == numCourses;
    }
}
