package tony.alg.graph;

import tony.util.DirectionGraph;

import java.util.*;

/**
 * 图的拓扑排序
 */
public class TopologySort {

    /**
     * 通过队列
     */
    public static Iterable<Integer> sortByQueue(DirectionGraph g){
        int n = g.V();
        int[] in = new int[n];

        List<Integer>[] adjs = g.getAdj();
        for (List<Integer> adj : adjs){
            for (Integer target : adj){
                in[target]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        int current = 0;
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
            Integer i = queue.poll();
            current++;
            result.add(i);
            for (int a : adjs[i]) {
                in[a]--;
                if (in[a] == 0) {
                    queue.offer(a);
                }
            }
        }

        if (current != n){
            return null;
        } else {
            return result;
        }
    }

    /**
     * 通过dfs的逆后序
     */
    public static Iterable<Integer> sortByDFS(DirectionGraph g){
        List<Integer> result = new ArrayList<>();
        int n = g.V();
        boolean[] check = new boolean[n];
        boolean[] mark = new boolean[n];
        for (int i = 0; i < n; i++){
            if (mark[i]){
                continue;
            }
            if (dfs(g, i, check, mark, result)){
                return null;
            }
        }
        Collections.reverse(result);
        return result;
    }

    private static boolean dfs(DirectionGraph g, int v, boolean[] check, boolean[] mark, List<Integer> result) {
        check[v] = true;
        mark[v] = true;
        for (int ea : g.adj(v)) {
            if (check[v]){
                return true;
            } else if (!mark[v]){
                if (dfs(g, ea, check, mark, result)){
                    return true;
                }
            }
        }
        mark[v] = false;
        // dfs的逆后序排序是图的一个拓扑排序解
        result.add(v);
        return false;
    }

}
