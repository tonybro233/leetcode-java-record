package tony.leetcode.feature.graph;

// 133. 克隆图
// 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
// 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
// class Node {
//     public int val;
//     public List<Node> neighbors;
// }

// 测试用例格式：
// 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），
// 第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
// 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
// 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。

// 提示：
// 节点数不超过 100 。
// 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
// 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
// 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
// 图是连通图，你可以从给定节点访问到所有节点。

import java.util.*;

public class Clone_Graph {

    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }
        return dfs(node, new HashMap<>(150));
    }

    private Node dfs(Node node, Map<Integer, Node> cloning) {
        if (cloning.containsKey(node.val)) {
            return cloning.get(node.val);
        }
        Node newNode = new Node(node.val);
        cloning.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, cloning));
        }
        return newNode;
    }

    public Node cloneGraphBfs(Node node) {
        if (null == node) {
            return null;
        }
        Map<Integer, Node> visit = new HashMap<>(150);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node newHead = new Node(node.val);
        visit.put(node.val, newHead);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            Node cloned = visit.get(n.val);
            for (Node neighbor : n.neighbors) {
                if (!visit.containsKey(neighbor.val)) {
                    visit.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                cloned.neighbors.add(visit.get(neighbor.val));
            }
        }
        return newHead;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
