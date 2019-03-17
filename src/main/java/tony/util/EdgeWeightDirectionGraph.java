package tony.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EdgeWeightDirectionGraph {
    private final int V;				// 顶点数量
    private Set<GraphEdge>[] adj;		// 顶点指出的边
    private int E;						// 边的数量

    public EdgeWeightDirectionGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Set<GraphEdge>[])new HashSet[V];
        for (int v = 0;v < V;v++ ) {
            adj[v] = new HashSet<>();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public boolean addEdge(GraphEdge e) {
        boolean r = adj[e.either()].add(e);
        if (r) {
            E++;
        }
        return r;
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
