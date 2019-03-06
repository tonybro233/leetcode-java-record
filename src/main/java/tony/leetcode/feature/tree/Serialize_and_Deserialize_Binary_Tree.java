package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.*;

// 297. 二叉树的序列化与反序列化
// 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
// 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
// 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

// 示例:
//
// 你可以将以下二叉树：
//     1
//    / \
//   2   3
//      / \
//     4   5
// 序列化为 "[1,2,3,null,null,4,5]"

// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
// 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。

public class Serialize_and_Deserialize_Binary_Tree {

    // 层序遍历
    public String serialize2(TreeNode root) {
        if (null == root){
            return "null";
        }
        StringBuilder s = new StringBuilder();
        TreeNode obj = new TreeNode(0);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (null != queue.peekFirst()) {
            root = queue.pollFirst();
            if (obj != root) {
                s.append(root.val).append(",");
                queue.addLast(root.left == null ? obj : root.left);
                queue.addLast(root.right == null ? obj : root.right);
            } else {
                s.append("null,");
            }
        }
        s.deleteCharAt(s.length()-1);
        return s.toString();
    }

    public TreeNode deserialize2(String data) {
        String[] tree = data.split(",");
        if ("null".equals(tree[0])) {
            return null;
        }
        TreeNode obj = new TreeNode(0);
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        queue.addLast(root);
        int i = 1;
        while (null != queue.peekFirst()) {
            TreeNode cur = queue.pollFirst();
            if (cur == obj) {
                continue;
            }
            if (!"null".equals(tree[i])){
                cur.left = new TreeNode(Integer.parseInt(tree[i]));
                queue.addLast(cur.left);
            } else {
                cur.left = null;
                queue.addLast(obj);
            }
            if (!"null".equals(tree[i+1])){
                cur.right = new TreeNode(Integer.parseInt(tree[i+1]));
                queue.addLast(cur.right);
            } else {
                cur.right = null;
                queue.addLast(obj);
            }
            i += 2;
        }
        return root;
    }



    // 没有必要构建完全树，构建完整的二叉树将导致超时
    public String serialize(TreeNode root) {
        if (null == root){
            return "null";
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int colcount = 1;
        boolean hasval = true;
        TreeNode obj = new TreeNode(0);
        List<TreeNode> nodes = new ArrayList<>();
        while (hasval){
            hasval = false;
            for (int i = 0; i < colcount; i++){
                TreeNode node = deque.pollFirst();
                nodes.add(node);
                if (obj == node){
                    deque.addLast(obj);
                    deque.addLast(obj);
                } else {
                    if (null != node.left || null != node.right){
                        hasval = true;
                    }
                    if (null != node.left){
                        deque.addLast(node.left);
                    } else {
                        deque.addLast(obj);
                    }
                    if (null != node.right){
                        deque.addLast(node.right);
                    } else {
                        deque.addLast(obj);
                    }
                }
            }
            colcount <<= 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.size(); i++){
            if (obj == nodes.get(i)){
                sb.append("null,");
            } else {
                sb.append(nodes.get(i).val);
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (null == data || "null".equals(data)){
            return null;
        }
        String[] split = data.split(",");
        if (split.length == 0){
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(split[0]));

        TreeNode obj = new TreeNode(0);
        int cursor = 1, colcount = 1;
        Deque<TreeNode> current = new LinkedList<>();
        current.addLast(head);
        while (cursor < split.length){
            for (int i = 0; i < colcount; i++){
                TreeNode node = current.pollFirst();
                if (obj == node){
                    cursor += 2;
                    current.addLast(obj);
                    current.addLast(obj);
                } else {
                    if ("null".equals(split[cursor])){
                        node.left = null;
                        current.addLast(obj);
                    } else {
                        TreeNode one = new TreeNode(Integer.parseInt(split[cursor]));
                        node.left = one;
                        current.addLast(one);
                    }
                    cursor++;
                    if ("null".equals(split[cursor])){
                        node.right = null;
                        current.addLast(obj);
                    } else {
                        TreeNode one = new TreeNode(Integer.parseInt(split[cursor]));
                        node.right = one;
                        current.addLast(one);
                    }
                    cursor++;
                }
            }
            colcount <<= 1;
        }

        return head;
    }


    public static void main(String[] args){
        Serialize_and_Deserialize_Binary_Tree tool = new Serialize_and_Deserialize_Binary_Tree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        // n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        String s = tool.serialize2(n1);
        System.out.println(s);
        TreeNode node = tool.deserialize2(s);
        TreeNode.prettyPrintTree(node);
        //
        // TreeNode treeNode = tool.deserialize("1,2,3,null,null,4,5");
        // System.out.println(treeNode.toString());
    }
}
