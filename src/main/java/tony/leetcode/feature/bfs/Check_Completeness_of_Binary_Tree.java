package tony.leetcode.feature.bfs;

import tony.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Check_Completeness_of_Binary_Tree {

    public boolean isCompleteTree(TreeNode root) {
        // 这种解法需要对题目要求进行一定的转换
        // 题目的条件等价于BFS遇到空之后不能再遍历到其他节点
        // 另外一种解法是计算每个节点的位置，所有节点位置必须连续
        if (null == root) {
            return false;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean nullMark = false;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.pollFirst();
                if (null != node.left) {
                    if (nullMark) {
                        return false;
                    }
                    queue.addLast(node.left);
                } else {
                    nullMark = true;
                }
                if (null != node.right) {
                    if (nullMark) {
                        return false;
                    }
                    queue.addLast(node.right);
                } else {
                    nullMark = true;
                }
            }
        }

        return true;
    }

}
