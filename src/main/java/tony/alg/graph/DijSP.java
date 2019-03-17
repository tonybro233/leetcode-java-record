package tony.alg.graph;

import tony.util.EdgeWeightDirectionGraph;
import tony.util.GraphEdge;
import tony.util.IndexMinPQ;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Dijkstra算法，计算有向非负权重图的最短路径
 *
 * 从起点开始延伸最短路径，不断放松节点（放松时会调整队列中节点的路径或加入新的节点）
 * 路径中还在队列里的disTo最小的节点肯定比已经放松过（移出队列）的节点disTo大，比没进入队列的节点的disTo小，
 * 所以队列中disTo最小的节点是下一个被放松的节点
 */
public class DijSP {
    private GraphEdge[] edgeTo;			// 表示最短路径中指向该路径中顶点的edge
    private double[] disTo;				// 表示顶点距离起点的最短路径值
    private IndexMinPQ<Double> pq;		// 索引优先队列，用来判断放松哪个节点

    public DijSP(EdgeWeightDirectionGraph G , int s) {
        edgeTo = new GraphEdge[G.V()];
        disTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());

        // 将每个顶点的距离初始化为正无穷
        for (int v = 0; v < G.V(); v++) {
            disTo[v] = Double.POSITIVE_INFINITY;
        }

        // 起点的距离初始化为0
        disTo[s] = 0;

        // 如果v是从s可达的，那么所有v-w的边只会放松一次，也就是每个顶点只会被放松1次
        // 以0初始化索引优先队列，不断删除路径最短的节点，并对其放松
        pq.insert(0, 0.0);
        while (!pq.isEmpty()){
            relax(G, pq.delMin());
        }
    }

    /**
     * 放松一个顶点：遍历每一个该顶点指出的节点，如果disTo[v] + 指出边权重 < disTo[w], 则更新disTo[w]
     * 放松边v-w意味着检查从s到w的最短路径会否是先从s到v然后再由v到w，如果是则更新信息，而对顶点的放松
     * 就是对顶点指出的所有边进行放松
     *
     * @param G
     * @param v
     */
    private void relax(EdgeWeightDirectionGraph G, int v) {
        for (GraphEdge e : G.adj(v)) {
            int w = e.to();
            if (disTo[v] + e.weight() < disTo[w]) {
                disTo[w] = disTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, disTo[w]);
                } else {
                    // 插入时一定会进入这个if块，因为初始值为正无穷
                    pq.insert(w, disTo[w]);
                }
            }
        }
    }

    public double distTo(int v){
        return disTo[v];
    }

    public boolean hasPathTo(int v){
        return disTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<GraphEdge> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        Deque<GraphEdge> edges = new LinkedList<>();
        for (GraphEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
            edges.addLast(e);
        }
        return edges;
    }
}
