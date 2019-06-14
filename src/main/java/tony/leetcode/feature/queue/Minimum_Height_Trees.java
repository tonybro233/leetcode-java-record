package tony.leetcode.feature.queue;

import java.util.*;

// 310. 最小高度树
// 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，
// 在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，
// 写出一个函数找到所有的最小高度树并返回他们的根节点。
//
// 格式
// 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
// 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，
// 因此不会同时出现在 edges 里。
//
// 示例 1:
// 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
//
//         0
//         |
//         1
//        / \
//       2   3
//
// 输出: [1]

// 示例 2:
// 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
//
//      0  1  2
//       \ | /
//         3
//         |
//         4
//         |
//         5
//
// 输出: [3, 4]

// 说明:
//  根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。
//  换句话说，一个任何没有简单环路的连通图都是一棵树。
//  树的高度是指根节点和叶子节点之间最长向下路径上边的数量。

public class Minimum_Height_Trees {

    // 位运算辅助
    public List<Integer> findMinHeightTrees3(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        int[] connected = new int[n]; // connected[i] 记录与节点i连接的节点
        int[] degree = new int[n]; // 记录节点的度数

        for(int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            connected[v1] ^= v2; //通过异或存储所有与之相邻的节点
            connected[v2] ^= v1;

            degree[v1]++;
            degree[v2]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i++) {
            if(degree[i] == 1) {
                queue.offer(i);
            }
        }

        while(n > 2 && !queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int v = queue.poll();
                n--;
                // 这个异或直接省去了一层循环？。。
                int v1 = connected[v]; // 与节点v相邻的所有节点
                connected[v1] ^= v;
                degree[v1]--;
                if(degree[v1] == 1) {
                    queue.add(v1);
                }
            }
        }

        return new ArrayList<>(queue);
    }

    // 循环减去邻边数量为1的节点
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if (edges.length == 0){
            return Collections.singletonList(0);
        }
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n;i++){
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int left = n;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n;i++){
            set.add(i);
        }

        // 这里可优化为队列
        while (left > 2){
            Set<Integer> toRemove = new HashSet<>();
            for (Integer point : set){
                if (graph[point].size() == 1){
                    left--;
                    toRemove.add(point);
                }
            }

            // 只要处理移除点对应的graph[v]中点即可
            for (Set<Integer> adjacent : graph){
                adjacent.removeAll(toRemove);
            }
            set.removeAll(toRemove);
        }

        return new ArrayList<>(set);
    }


    // 对每个节点进行bfs，超时
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0){
            return Collections.singletonList(0);
        }
        List<Integer>[] graph = new ArrayList[n], record = new ArrayList[n];
        for (int i = 0; i < n;i++){
            graph[i] = new ArrayList<>();
            record[i] = new ArrayList<>();
        }

        for (int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int min = n;
        for (int i = 0; i< n;i++){
            int depth = bfs(i, graph);
            min = Math.min(min, depth);
            record[depth - 1].add(i);
        }

        return record[min-1];
    }

    private int bfs(int start, List<Integer>[] graph){
        int count = -1;
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();

        int le = 1;
        deque.addFirst(start);
        visit.add(start);
        while (null != deque.peekLast()) {
            int tmp = 0;
            for (int i = 0; i < le;i++){
                Integer point = deque.pollLast();
                List<Integer> outs = graph[point];
                for (Integer out : outs){
                    if (!visit.contains(out)){
                        deque.addFirst(out);
                        visit.add(out);
                        tmp++;
                    }
                }
            }
            le = tmp;
            count++;
        }

        return count;
    }

    public static void main(String[] args){
        List<Integer> list = new Minimum_Height_Trees().findMinHeightTrees(
                6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}});
        System.out.println(list.toString());
    }
}
