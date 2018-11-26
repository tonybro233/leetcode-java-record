package tony.leetcode.feature.bfs;

import tony.util.TreeNode;

import java.util.*;

// 102 二叉树的层次遍历
// 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 例如:
// 给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回其层次遍历结果：
//
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

public class Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> valQue = new ArrayDeque<>();
        Deque<Integer> levelQue = new ArrayDeque<>();
        valQue.addLast(root);
        levelQue.addLast(0);
        while (valQue.size() > 0){
            TreeNode node = valQue.pollFirst();
            Integer level = levelQue.pollFirst();
            if (result.size() > level){
                result.get(level).add(node.val);
            } else {
                List<Integer> newline = new ArrayList<>();
                newline.add(node.val);
                result.add(newline);
            }
            if (null != node.left){
                valQue.addLast(node.left);
                levelQue.addLast(level+1);
            }
            if (null != node.right){
                valQue.addLast(node.right);
                levelQue.addLast(level+1);
            }
        }
        return result;
    }

    // 维护当前层和下一层的的节点和数
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rowResult = new ArrayList<>();
        if(root == null){
            return result;
        }

        int next = 0;//下一行有多少个元素
        int num = 1;//当前层有多少结点，为1 是根节点初始化

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode now = queue.poll();
            rowResult.add(now.val);
            num--;
            if(now.left != null){
                queue.add(now.left);
                next++;
            }
            if(now.right != null){
                queue.add(now.right);
                next++;
            }

            if(num == 0){
                num = next;
                next = 0;
                result.add(rowResult);
                rowResult = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
