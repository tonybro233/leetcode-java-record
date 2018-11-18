package tony.util;

/**
 * 图的一条边
 * 带有权重，可以有向也可以无向
 */
public class GraphEdge implements Comparable<GraphEdge> {
    private final int v;
    private final int w;
    private final double weight;

    /**
     * 2个点和权重构造(有向图中v为起点)
     */
    public GraphEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 权重
     */
    public double weight() {
        return weight;
    }

    /**
     * 无向权重图使用
     * 顶点之一
     */
    public int either() {
        return v;
    }

    /**
     * 另一个顶点
     */
    public int other(int V) {

        if (V == v) {
            return w;
        } else if (V == w) {
            return v;
        } else {
            throw new RuntimeException("Inconsistent edge");
        }
    }

    /**
     * 有向权重图使用
     * 指出顶点
     */
    public int from() {
        return v;
    }

    /**
     * 指向顶点
     */
    public int to() {
        return w;
    }


    @Override
    public int compareTo(GraphEdge that) {
        return Double.compare(this.weight, that.weight);
    }
}
