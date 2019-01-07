package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 513
// 给定一个二叉树，在树的最后一行找到最左边的值。
// 注意: 您可以假设树（即给定的根节点）不为 NULL。

public class Find_Bottom_Left_Tree_Value {

    // 很明显的BFS，但是需要记录层数

    public static void main(String[] args){
        TreeNode input = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        input.left = t2;
        input.right = t3;
        int re = new Find_Bottom_Left_Tree_Value().findBottomLeftValue(input);
        System.out.print(re);
    }


    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<>();
        Deque<Integer> level = new ArrayDeque<>();
        que.offer(root);
        level.offer(0);
        int result = root.val;
        int current = -1;
        while (true){
            TreeNode now = que.pollLast();
            Integer le = level.pollLast();
            if (le != current){
                result = now.val;
                current = le;
            }
            int num = 0;
            if (null != now.left){
                que.addFirst(now.left);
                level.addFirst(le+1);
            }
            if (null != now.right){
                que.addFirst(now.right);
                level.addFirst(le+1);
            }

            if (null == que.peekLast()){
                break;
            }
        }

        return result;
    }
}
