package tony.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 无权重有向图
 * 以实数代替节点
 */
public class DirectionGraph {

    // 顶点数
    private final int V;

    // 边数
    private int E;

    private List<Integer>[] adj;

    // 构造V个顶点的有向图
    public DirectionGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V;v++) {
            adj[v] = new ArrayList<>();
        }
    }

    // 返回顶点个数
    public int V() {
        return V;
    }

    // 返回边个数
    public int E() {
        return E;
    }

    // 增加一条有向边
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    // 返回某个顶点 指出 的节点
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public List<Integer>[] getAdj(){
        return this.adj;
    }

    // 返回反向图
    public DirectionGraph reverse() {
        DirectionGraph R = new DirectionGraph(this.V);
        for (int v = 0; v < V;v++) {
            for (int w:adj[v]) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    // 深度优先搜索，从start是否可以达到v
    public boolean IsReachableByDFS(int start, int v) {
        boolean[] marked  = new boolean[this.V];
        Stack<Integer> st = new Stack<Integer>();
        st.push(start);
        marked[start] = true;

        while (st.size() > 0) {
            boolean allcheck = true;
            for (int w: adj[st.peek()]) {
                if (w == v) {
                    return true;
                }
                if (!marked[w]) {
                    marked[w] = true;
                    st.push(w);
                    allcheck = false;
                    break;
                }
            }
            if (allcheck) {
                st.pop();
            }
        }

        return false;
    }

    // 验证是否有环
    public boolean hasCycle(){
        boolean[] mark = new boolean[V];
        for (int i = 0; i < V; i++){
            if (dfs(i, mark)){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int v, boolean[] mark){
        mark[v] = true;
        for (int w : adj[v]){
            if (!mark[w]){
                return dfs(w, mark);
            } else {
                return true;
            }
        }
        mark[v] = false;
        return false;
    }
}
