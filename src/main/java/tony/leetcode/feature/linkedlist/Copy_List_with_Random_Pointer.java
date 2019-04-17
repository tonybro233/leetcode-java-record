package tony.leetcode.feature.linkedlist;

import java.util.IdentityHashMap;
import java.util.Map;

// 138. 复制带随机指针的链表
// 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
//
// 要求返回这个链表的深拷贝。
//
// 提示：
// 你必须返回给定头的拷贝作为对克隆列表的引用。

public class Copy_List_with_Random_Pointer {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    // 另一种思路是将复制的节点放在原节点的后面
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new IdentityHashMap<>();
        Node dummy = new Node();
        Node current = dummy, head2 = head;
        while (head != null){
            Node cnode = new Node(head.val, null, null);
            current.next = cnode;
            map.put(head, cnode);
            current = cnode;
            head = head.next;
        }

        current = dummy.next;
        while (head2 != null){
            if (null != head2.random){
                current.random = map.get(head2.random);
            }
            head2 = head2.next;
            current = current.next;
        }

        return dummy.next;
    }
}

