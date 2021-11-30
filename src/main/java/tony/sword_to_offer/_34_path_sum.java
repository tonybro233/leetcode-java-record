package tony.sword_to_offer;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 34. 二叉树中和为某一值的路径
// 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
// 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
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
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

public class _34_path_sum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        find(root, new ArrayList<>(), 0, sum, result);
        return result;
    }

    public void find(TreeNode node, List<Integer> current, int currentSum, int sum, List<List<Integer>> result) {
        if (null == node) {
            return;
        }
        current.add(node.val);
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            if (currentSum == sum) {
                result.add(new ArrayList<>(current));
            }
        } else {
            find(node.left, current, currentSum, sum, result);
            find(node.right, current, currentSum, sum, result);
        }

        current.remove(current.size() - 1);
    }

}
