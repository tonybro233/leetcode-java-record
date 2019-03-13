package tony.leetcode.feature.binary_search;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 230. 二叉搜索树中第K小的元素
// 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
//
// 说明：
// 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
//
// 示例 1:
// 输入: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// 输出: 1

// 示例 2:
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// 输出: 3

// 进阶：
// 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，
// 你将如何优化 kthSmallest 函数？

public class Kth_Smallest_Element_in_a_BST {

    private int counter = 0;
    private int ret = 0;


    /**
     * 审题啊，这是个二叉搜索树
     * 二叉搜索树中序遍历就是升序序列, 中序遍历时设置一个 counter
     * 每访问一个节点 counter 加1, counter = k即找到第 k 大的数
     */
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ret;
    }

    private void inorder(TreeNode r, int k) {
        if(r == null) {
            return;
        }
        inorder(r.left, k);
        if(++counter == k) {
            ret = r.val;
            return;
        }
        inorder(r.right, k);
    }

    // 直接进行排序
    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> record = new ArrayList<>();
        preorder(root, record);
        Collections.sort(record);
        return record.get(k-1);
    }

    private void preorder(TreeNode node, List<Integer> record){
        if (null == node){
            return;
        }
        record.add(node.val);
        preorder(node.left, record);
        preorder(node.right, record);
    }
}
