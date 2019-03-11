package tony.leetcode.feature.graph;

import java.util.*;

// 210. 课程表 II
// 现在你总共有 n 门课需要选，记为 0 到 n-1。
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，
// 你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
// 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
// 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
//
// 示例 1:
// 输入: 2, [[1,0]]
// 输出: [0,1]
// 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。

// 示例 2:
// 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
// 输出: [0,1,2,3] or [0,2,1,3]
// 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。
// 并且课程 1 和课程 2 都应该排在课程 0 之后。因此，一个正确的课程顺序是 [0,1,2,3] 。
// 另一个正确的排序是 [0,2,1,3] 。

// 说明:
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
// 你可以假定输入的先决条件中没有重复的边。

public class Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        Arrays.setAll(graph, value -> new ArrayList<>());
        int[] in = new int[numCourses];
        for (int[] each : prerequisites){
            graph[each[1]].add(each[0]);
            in[each[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        int current = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()){
            Integer i = queue.poll();
            result[current++] = i;
            for (int a : graph[i]) {
                in[a]--;
                if (in[a] == 0) {
                    queue.offer(a);
                }
            }
        }

        // 后自加，不相等说明有环
        if (current != numCourses){
            return new int[0];
        } else {
            return result;
        }
    }

    // dfs逆后序
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        Arrays.setAll(graph, value -> new ArrayList<>());
        for (int[] pair : prerequisites){
            graph[pair[0]].add(pair[1]);
        }

        boolean[] record = new boolean[numCourses];
        boolean[] once = new boolean[numCourses];
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < numCourses;i++){
            if (!record[i]){
                if (dfs(graph, i, once, record, list)){
                    return new int[0];
                }
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0;i < numCourses; i++){
            result[i] = list.get(numCourses - 1 - i);
        }

        return result;
    }

    private boolean dfs(List<Integer>[] graph, int v, boolean[] once, boolean[] mark, List<Integer> list){
        if (once[v]){
            return true;
        }
        if (mark[v]){
            return false;
        }
        once[v] = true;
        mark[v] = true;
        for (Integer ea : graph[v]){
            if (dfs(graph, ea, once, mark, list)){
                return true;
            }
        }
        once[v] = false;
        list.add(v);
        return false;
    }

}
