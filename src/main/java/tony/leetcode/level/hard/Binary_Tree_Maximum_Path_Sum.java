package tony.leetcode.level.hard;

import tony.util.TreeNode;

// 124. 二叉树中的最大路径和
// 给定一个非空二叉树，返回其最大路径和。
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
//
// 示例 1:
// 输入: [1,2,3]
//
//        1
//       / \
//      2   3
// 输出: 6

// 示例 2:
// 输入: [-10,9,20,null,null,15,7]
//
//    -10
//    / \
//   9  20
//     /  \
//    15   7
// 输出: 42

public class Binary_Tree_Maximum_Path_Sum {

    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getOneWayMax(root);
        return ret;
    }

    // 这尼玛。。
    // 这个方法本身求的是当前节点往下单向遍历的最大路径和
    // 这样以本节点为最高节点的最大路径就可以通过: 左节点向下遍历的最大值 和 右节点向下遍历最大值 以及本身的值 来计算得出
    // 通过全局变量来求总的最大值
    private int getOneWayMax(TreeNode r) {
        if(r == null) {
            return 0;
        }
        int left = Math.max(0, getOneWayMax(r.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getOneWayMax(r.right));
        ret = Math.max(ret, r.val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + r.val;
    }
}
