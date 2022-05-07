package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.*;

// 508. 出现次数最多的子树元素和
// 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根
// 的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。
// 如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
//
// 示例 1
// 输入:
//   5
//  /  \
// 2   -3
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
//
// 示例 2
// 输入:
//   5
//  /  \
// 2   -5
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。

// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。

public class Most_Frequent_Subtree_Sum {

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        update(root);
        int max = Integer.MIN_VALUE;
        for (Integer val : map.values()) {
            max = Math.max(max, val);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private int update(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int sum = update(node.left) + update(node.right) + node.val;
        node.val = sum;
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;
    }
}
