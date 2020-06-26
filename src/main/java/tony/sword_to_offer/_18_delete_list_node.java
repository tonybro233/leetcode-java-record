package tony.sword_to_offer;

import tony.util.ListNode;

// 18. 删除链表的节点
// 给定单向链表的头指针和一个要删除的节点的值，定义一个函数在O(1)时间内删除该节点。
// 返回删除后的链表的头节点。

public class _18_delete_list_node {

    public ListNode deleteNode(ListNode head, ListNode toDelete) {
        if (head.equals(toDelete)) {
            return head.next;
        }

        if (toDelete.next == null) {
            // 尾节点，需要遍历
            ListNode n = head;
            while (n.next != toDelete) {
                n = n.next;
            }
            n.next = null;
        } else {
            // 非尾节点，假删除
            toDelete.val = toDelete.next.val;
            toDelete.next = toDelete.next.next;
        }

        return head;
    }

}
