package tony.leetcode.feature.dynamic_program;

import tony.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 337. 打家劫舍 III
// 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
// 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一
// 个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的
// 排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

// 示例 1:
// 输入: [3,2,3,null,3,null,1]
//
//      3
//     / \
//    2   3
//     \   \
//      3   1
//
// 输出: 7
// 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.

// 示例 2:
// 输入: [3,4,5,1,3,null,1]
//
//      3
//     / \
//    4   5
//   / \   \
//  1   3   1
//
// 输出: 9
// 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.

public class House_Robber_III {

    public int rob2(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (null == node) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int selected = node.val + left[1] + right[1];
        int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, notSelected};
    }

    // 每个节点要单独处理，不能按层统一算，傻逼
    public int rob(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 1, next = 0;
        int floor = 0;
        int lastDo = 0, lastNotDo = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            floor += node.val;
            cur--;
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (cur == 0) {
                int currentDo = lastNotDo + floor;
                int currentNotDo = Math.max(lastNotDo, lastDo);
                lastDo = currentDo;
                lastNotDo = currentNotDo;

                cur = next;
                next = 0;
                floor = 0;
            }
        }

        return Math.max(lastDo, lastNotDo);
    }

}
