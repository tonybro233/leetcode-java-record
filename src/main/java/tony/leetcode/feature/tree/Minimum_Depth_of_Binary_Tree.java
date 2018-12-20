package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 111. 二叉树的最小深度
// 给定一个二叉树，找出其最小深度。
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回它的最小深度  2.

public class Minimum_Depth_of_Binary_Tree {

    // bfs
    public int minDepth(TreeNode root) {
        if (null == root){
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        int result = 1;
        deque.addFirst(root);
        while (true){
            int count = deque.size();
            while (count > 0){
                TreeNode node = deque.pollLast();
                if (node.left == null && node.right == null){
                    return result;
                }
                if (null != node.left){
                    deque.addFirst(node.left);
                }
                if (null != node.right){
                    deque.addFirst(node.right);
                }
                count--;
            }
            result++;
        }
    }

    // 自递归的解法
    public int minDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth2(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth2(root.left) + 1;
        }
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }
}
