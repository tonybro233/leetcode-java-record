package tony.leetcode.feature.bfs;

import tony.util.TreeNode;

import java.util.*;

// 103. 二叉树的锯齿形层次遍历
// 给定一个二叉树，返回其节点值的锯齿形层次遍历。
// （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
// 给定二叉树 [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回锯齿形层次遍历如下：
//
// [
//   [3],
//   [20,9],
//   [15,7]
// ]

public class Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root){
            return result;
        }
        boolean goRight = true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int rowcount = deque.size();
        while (rowcount > 0){
            List<Integer> row = new ArrayList<>(rowcount);
            for (int i = 0; i < rowcount; i++){
                TreeNode node = deque.pollFirst();
                if (null != node.left){
                    deque.addLast(node.left);
                }
                if (null != node.right){
                    deque.addLast(node.right);
                }
                row.add(node.val);
            }
            // 也可以采用row.add(0, node.val)来处理，而不是翻转
            if (!goRight){
                Collections.reverse(row);
            }

            result.add(row);
            goRight = !goRight;
            rowcount = deque.size();
        }

        return result;
    }
}
