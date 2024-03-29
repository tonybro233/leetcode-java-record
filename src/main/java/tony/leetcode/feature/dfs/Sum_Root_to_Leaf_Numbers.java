package tony.leetcode.feature.dfs;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 129. 求根到叶子节点数字之和
// 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。
// 计算从根到叶子节点生成的所有数字之和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例 1:
// 输入: [1,2,3]
//     1
//    / \
//   2   3
// 输出: 25
// 解释:
// 从根到叶子节点路径 1->2 代表数字 12.
// 从根到叶子节点路径 1->3 代表数字 13.
// 因此，数字总和 = 12 + 13 = 25.

// 示例 2:
// 输入: [4,9,0,5,1]
//     4
//    / \
//   9   0
//  / \
// 5   1
// 输出: 1026
// 解释:
// 从根到叶子节点路径 4->9->5 代表数字 495.
// 从根到叶子节点路径 4->9->1 代表数字 491.
// 从根到叶子节点路径 4->0 代表数字 40.
// 因此，数字总和 = 495 + 491 + 40 = 1026.

public class Sum_Root_to_Leaf_Numbers {

    // 分治
    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = sum * 10 + node.val;

        // leaf
        if (node.left == null && node.right == null) {
            return sum;
        }

        // non-leaf
        return helper(node.left, sum) + helper(node.right, sum);
    }

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        List<Integer> values = new ArrayList<>();
        dfstracking(root, 0, values);
        int result = 0;
        for (int i = 0; i < values.size(); i++) {
            result += values.get(i);
        }
        return result;
    }

    private void dfstracking(TreeNode node, int value, List<Integer> values) {
        int newvalue = value * 10 + node.val;
        if (node.left == null && node.right == null) {
            values.add(newvalue);
        } else {
            if (null != node.left) {
                dfstracking(node.left, newvalue, values);
            }
            if (null != node.right) {
                dfstracking(node.right, newvalue, values);
            }
        }
    }
}
