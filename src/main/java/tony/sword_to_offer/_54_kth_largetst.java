package tony.sword_to_offer;

import tony.util.TreeNode;

// 54. 二叉搜索树的第k大节点
// 给定一棵二叉搜索树，请找出其中第k大的节点。
// 示例 1:
// 输入: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// 输出: 4
//
// 示例 2:
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// 输出: 4

public class _54_kth_largetst {

    public int kthLargest(TreeNode root, int k) {
        int rightCount = count(root.right);
        if (k - 1 == rightCount) {
            return root.val;
        } else if (k - 1 > rightCount) {
            return kthLargest(root.left, k - 1 - rightCount);
        } else {
            return kthLargest(root.right, k);
        }

    }

    private int count(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }

}
