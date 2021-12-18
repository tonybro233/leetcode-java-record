package tony.leetcode.feature.dfs;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 113. 路径总和II
// 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
// 给定如下二叉树，以及目标和 sum = 22，
//
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// 返回:
//
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

public class Path_Sum_2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        search(root, sum, new ArrayList<>(), result);
        return result;
    }

    private void search(TreeNode node, int left, List<Integer> path, List<List<Integer>> result) {
        if (null == node) {
            return;
        }
        path.add(node.val);
        if (left == node.val && node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            search(node.left, left - node.val, path, result);
            search(node.right, left - node.val, path, result);
        }

        path.remove(path.size() - 1);
    }
}
