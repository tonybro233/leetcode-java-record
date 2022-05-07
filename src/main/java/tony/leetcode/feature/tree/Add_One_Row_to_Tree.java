package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

// 623. 在二叉树中增加一行
// 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
// 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，
// 为 N 创建两个值为 v 的左子树和右子树。
// 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
// 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
//
// 示例 1:
// 输入:
// 二叉树如下所示:
//        4
//      /   \
//     2     6
//    / \   /
//   3   1 5
//
// v = 1
// d = 2
//
// 输出:
//        4
//       / \
//      1   1
//     /     \
//    2       6
//   / \     /
//  3   1   5
//
// 示例 2:
// 输入:
// 二叉树如下所示:
//       4
//      /
//     2
//    / \
//   3   1
//
// v = 1
// d = 3
//
// 输出:
//       4
//      /
//     2
//    / \
//   1   1
//  /     \
// 3       1

// 注意:
// 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
// 输入的二叉树至少有一个节点。

public class Add_One_Row_to_Tree {

    // 常规bfs
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (1 == d) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while (d > 2) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (null != node.left) {
                    deque.addLast(node.left);
                }
                if (null != node.right) {
                    deque.addLast(node.right);
                }
            }
            d--;
        }

        while (null != deque.peekFirst()) {
            TreeNode node = deque.pollFirst();
            TreeNode newLeft = new TreeNode(v), newRight = new TreeNode(v);
            newLeft.left = node.left;
            newRight.right = node.right;
            node.left = newLeft;
            node.right = newRight;
        }

        return root;
    }
}
