package tony.leetcode.feature.graph;

// 743. 网络延迟时间
// 有 N 个网络节点，标记为 1 到 N。
//
// 给定一个列表 times，表示信号经过有向边的传递时间。
// times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
//
// 现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？
// 如果不能使所有节点收到信号，返回 -1。
//
// 注意:
// N 的范围在 [1, 100] 之间。
// K 的范围在 [1, N] 之间。
// times 的长度在 [1, 6000] 之间。
// 所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。

import java.util.Arrays;

public class Network_Delay_Time {

    // 本题意为K可以同时发送多个信号，因此求的是K到各个节点最短路径的最大值
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dis = new int[N+1];  // 存储K到每个点的最短距离
        Arrays.fill(dis, Integer.MAX_VALUE); // 取MAX方便判断不可达的点
        dis[K] = 0;

        // floyd-Warshall 算法
        for (int i = 0; i <= N; i++){
            for (int[] edge : times){
                //输入中节点编号是基1，故减1
                int u = edge[0], v = edge[1], w = edge[2];
                if (dis[u] != Integer.MAX_VALUE && dis[v] > dis[u] + w) {
                    dis[v] = dis[u] + w;
                }
            }
        }

        //求最短距离中的最大值
        int res = 0;
        for(int i=0; i<N; i++){
            res = Math.max(res, dis[i]);
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}
