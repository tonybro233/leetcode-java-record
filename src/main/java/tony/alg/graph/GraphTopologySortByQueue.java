package tony.alg.graph;

import tony.util.DirectionGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 通过队列对有向图进行拓扑排序
 */
public class GraphTopologySortByQueue {
    private int[] in ;

    public GraphTopologySortByQueue(DirectionGraph g){
        int n = g.V();
        in = new int[n];

        List<Integer>[] adjs = g.getAdj();
        for (List<Integer> adj : adjs){
            for (Integer target : adj){
                in[target]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        int current = 0;
        int[] result = new int[n];

        while (!queue.isEmpty()){
            Integer i = queue.poll();
            result[current++] = i;
            for (int a : adjs[i]) {
                in[a]--;
                if (in[a] == 0) {
                    queue.offer(a);
                }
            }
        }

        if (current != n){
            System.out.println("The input graph has cyclic");
        } else {
            System.out.println(Arrays.toString(result));
        }
    }

}
