package tony.leetcode.feature.tree;

import tony.util.TreeNode;


// 108 将有序数组转换为 二叉搜索树
// 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
// 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//       0
//      / \
//    -3   9
//    /   /
//  -10  5

// 注意平衡二叉搜索树的定义：
// （1）若它的左子树不空，则其左子树上任意结点的关键字的值都小于根节点关键字的值。
// （2）若它的右子树不空，则其右子树上任意结点的关键字的值都大于根节点关键字的值。
// （3）它的左、右子树本身又是一个二叉查找树。

public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int min, int max) {
        // 由于二叉搜索树的性质可根据中点进行处理
        if (min > max) {
            return null;
        }
        int mid = (min + max) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, min, mid - 1);
        node.right = build(nums, mid + 1, max);
        return node;
    }
}
