package tony.alg.graph;

import tony.util.EdgeWeightDirectionGraph;
import tony.util.GraphEdge;
import tony.util.IndexMinPQ;

/**
 * 即时版本的最小生成树Prim算法
 *
 * 生成树是包含所有顶点的无环连通子图，最小生成树即树中所有边权值和最小的树
 */
public class PrimMST {
    private boolean[] marked;		// 节点是否在树上
    private double[] disTo;			// 树邻接节点距离树最近（权值最小）的边的权值
    private GraphEdge[] edgeTo;		// 树邻接节点距离树最近（权值最小）的边

    // 索引优先队列，用一个整数和对象关联，用以对对象的快速索引，根据索引更新对象的值（同时会调整位置保证优先队列的形态）
    private IndexMinPQ<Double> pq;	// 索引值是节点编号，排序值是disTo[节点编号]（Double类型权值）

    public PrimMST(EdgeWeightDirectionGraph G) {
        edgeTo = new GraphEdge[G.V()];
        disTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v= 0; v<G.V();v++) {
            disTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<Double>(G.V());

        disTo[0] = 0;
        pq.insert(0, 0.0);

        // 最终所有节点都会加入最小生成树
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());	// 删除最小值返回的是对象的索引值，即节点编号
        }
    }

    private void visit(EdgeWeightDirectionGraph G, int v) {
        // v添加到树中
        marked[v] = true;

        // 遍历添加的节点的所有边
        for (GraphEdge e: G.adj(v))
        {
            int w = e.other(v);

            // w已经在树中直接跳过
            if (marked[w]) {
                continue;
            }

            // 发现w节点有距离树更近的边
            if (e.weight() < disTo[w]) {
                edgeTo[w] = e;
                disTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, disTo[w]);	// 更改索引值关联的对象，也就是距离树的最近距离发生了改变
                } else {
                    pq.insert(w, disTo[w]);		// 插入索引值，也就是有新的节点出现在树的邻接
                }
            }
        }
    }
}
