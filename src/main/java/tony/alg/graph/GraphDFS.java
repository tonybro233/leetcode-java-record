package tony.alg.graph;

import tony.util.DirectionGraph;

import java.util.Stack;

public class GraphDFS {
    private boolean[] mark;

    public GraphDFS(DirectionGraph g, int v) {
        int n = g.V();
        mark = new boolean[n];
        dfs(g, v);
    }

    private void dfs(DirectionGraph g, int v) {
        System.out.println(v);
        mark[v] = true;
        for (int ea : g.adj(v)) {
            if (!mark[v]) {
                dfs(g,ea);
            }
        }
    }
}
