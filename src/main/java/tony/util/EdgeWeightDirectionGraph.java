package tony.util;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightDirectionGraph {
    private final int V;				// 顶点数量
    private List<GraphEdge>[] adj;		// 顶点指出的边
    private int E;						// 边的数量

    public EdgeWeightDirectionGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (List<GraphEdge>[])new List[V];
        for (int v = 0;v < V;v++ ) {
            adj[v] = new ArrayList<>();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(GraphEdge e) {
        adj[e.either()].add(e);
        E++;
    }

    public Iterable<GraphEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<GraphEdge> edges() {
        List<GraphEdge> bag = new ArrayList<>();
        for (int v= 0; v < V; v++) {
            for (GraphEdge each: adj[v]) {
                bag.add(each);
            }
        }
        return bag;
    }
}
