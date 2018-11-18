package tony.alg.graph;

import tony.util.DirectionGraph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    boolean[] mark;

    public void bfs(DirectionGraph g, int s) {
        int n = g.V();
        mark = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.offer(s);
        mark[s] = true;
        System.out.println(s);
        while (que.size() != 0) {
            int x = que.remove();
            for (int ea : g.adj(x)) {
                if (!mark[ea]) {
                    que.offer(ea);
                    mark[ea] = true;
                    System.out.println(x);
                }
            }
        }
    }
}
