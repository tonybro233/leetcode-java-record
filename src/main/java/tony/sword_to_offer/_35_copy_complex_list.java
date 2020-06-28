package tony.sword_to_offer;

// 35. 复杂链表的复制
// 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
// 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

public class _35_copy_complex_list {

    // hash法不够高级
    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        Node node = head;

        // 在每个节点后面插一个节点
        while (null != node) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            copy.random = node.random;
            node.next = copy;
            node = copy.next;
        }

        // 处理random
        node = head;

        while (node != null) {
            Node copy = node.next;
            if (null != node.random) {
                copy.random = node.random.next;
            }

            node = node.next.next;
        }

        // 拆分
        Node newHead = head.next;
        node = head;
        Node pre = new Node(0);
        while (node != null) {
            pre.next = node.next;
            pre = node.next;

            node.next = node.next.next;
            node = node.next;
        }

        return newHead;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
