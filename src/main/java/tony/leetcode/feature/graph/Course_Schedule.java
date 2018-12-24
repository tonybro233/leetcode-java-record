package tony.leetcode.feature.graph;

import java.util.*;

// 207. 课程表
// 现在你总共有 n 门课需要选，记为 0 到 n-1。
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，
// 你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
//
// 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
//
// 示例 1:
// 输入: 2, [[1,0]]
// 输出: true
// 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

// 示例 2:
// 输入: 2, [[1,0],[0,1]]
// 输出: false
// 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；
// 并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

// 说明:
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
// 你可以假定输入的先决条件中没有重复的边。

public class Course_Schedule {

    // 使用queue求解
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] in = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            in[i] = 0;
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            in[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int i = queue.poll();
            for (int a : graph.get(i)) {
                in[a]--;
                if (in[a] == 0) {
                    queue.offer(a);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 有向图使用dfs寻找环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        Arrays.setAll(graph, value -> new ArrayList<>());
        for (int[] each : prerequisites){
            graph[each[1]].add(each[0]);
        }
        boolean[] record = new boolean[numCourses];
        for (int i = 0; i < numCourses;i++){
            if (!record[i]){
                if (dfs(graph, i, new boolean[numCourses], record)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(List<Integer>[] graph, int now, boolean[] current, boolean[] record){
        if (current[now]){
            return true;
        }
        current[now] = true;
        record[now] = true;
        List<Integer> pointTo = graph[now];
        for (Integer to : pointTo) {
            if (dfs(graph, to, current, record)){
                return true;
            }
        }
        current[now] = false;
        return false;
    }
}
