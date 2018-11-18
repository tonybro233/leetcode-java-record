package tony.alg.graph;

import tony.util.DirectionGraph;

public class GraphDFS {
    private int[] mark;

    public GraphDFS(DirectionGraph g, int v) {
        int n = g.V();
        mark = new int[n];
        dfs(g, v);
    }

    private void dfs(DirectionGraph g, int v) {
        System.out.println(v);
        mark[v] = 1;
        for (int ea : g.adj(v)) {
            if (1 != mark[v]) {
                dfs(g,ea);
            }
        }
    }
}
