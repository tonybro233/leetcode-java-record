package tony.alg.graph;

import tony.util.EdgeWeightDirectionGraph;
import tony.util.GraphEdge;
import tony.util.IndexMinPQ;

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

        // 以0初始化索引优先队列，不断删除路径最短的节点，并对其放松
        pq.insert(0, 0.0);
        while (!pq.isEmpty()){
            relax(G, pq.delMin());
        }
    }

    /**
     * 放松一个顶点：遍历每一个该顶点指出的节点，如果disTo[v] + 指出边权重 < disTo[w], 则更新disTo[w]
     * @param G
     * @param v
     */
    private void relax(EdgeWeightDirectionGraph G, int v) {
        for (GraphEdge e : G.adj(v))
        {
            int w = e.to();
            if (disTo[v] + e.weight() < disTo[w])
            {
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
}
