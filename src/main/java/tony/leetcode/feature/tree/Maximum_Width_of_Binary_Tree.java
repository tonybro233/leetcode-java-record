package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 662. 二叉树最大宽度
// 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
// 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
//
// 示例 1:
// 输入:
//            1
//          /   \
//         3     2
//        / \     \
//       5   3     9
// 输出: 4
// 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。

// 示例 2:
// 输入:
//           1
//          /
//         3
//        / \
//       5   3
//
// 输出: 2
// 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。

// 示例 3:
// 输入:
//           1
//          / \
//         3   2
//        /
//       5
// 输出: 2
// 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。

// 示例 4:
// 输入:
//
//           1
//          / \
//         3   2
//        /     \
//       5       9
//      /         \
//     6           7
// 输出: 8
// 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。

// 注意: 答案在32位有符号整数的表示范围内。

public class Maximum_Width_of_Binary_Tree {

    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        if (null == root) {
            return result;
        } else {
            result = 1;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        // 本题没有用到TreeNode的val，因此可以直接利用val而不是再用另外的Deque，如果允许修改的话
        Deque<Integer> posQueue = new ArrayDeque<>();
        queue.addLast(root);
        posQueue.addLast(1);

        while (!posQueue.isEmpty()) {
            Integer begin = null, end = null;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.pollFirst();
                Integer pos = posQueue.pollFirst();
                if (null == begin) {
                    begin = pos;
                } else {
                    end = pos;
                }
                if (null != node.left) {
                    queue.addLast(node.left);
                    posQueue.addLast(pos * 2 - 1);
                }
                if (null != node.right) {
                    queue.addLast(node.right);
                    posQueue.addLast(pos * 2);
                }
            }
            if (null != end) {
                result = Math.max(result, end - begin + 1);
            }
        }

        return result;
    }

}
