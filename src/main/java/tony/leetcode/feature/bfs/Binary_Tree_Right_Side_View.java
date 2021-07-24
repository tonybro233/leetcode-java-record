package tony.leetcode.feature.bfs;

import tony.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 199. 二叉树的右视图
// 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

public class Binary_Tree_Right_Side_View {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int cur = 1, next = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            cur--;
            if (cur == 0) {
                result.add(node.val);
            }
            if (null != node.left) {
                queue.add(node.left);
                next++;
            }
            if (null != node.right) {
                queue.add(node.right);
                next++;
            }
            if (cur == 0) {
                cur = next;
                next = 0;
            }
        }

        return result;
    }

}
