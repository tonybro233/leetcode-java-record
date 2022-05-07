package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

import java.util.ArrayList;
import java.util.List;

// 143. 重排链表
// 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
// 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// 示例 1:
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.

// 示例 2:
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

public class Reorder_List {

    public void reorderList2(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) {
            return;
        }

        // 快慢指针分割链表并找到后面链表头部
        ListNode head2 = findMidAndCut(head);

        // 翻转后面的链表
        head2 = reverse(head2);

        // 链表融合
        merge(head, head2);
    }

    private ListNode findMidAndCut(ListNode head) {
        ListNode slow = head, fast = head, pre = null;
        while (null != fast.next && null != fast.next.next) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (null != fast.next) {
            pre = slow;
            slow = slow.next;
        }
        if (null != pre) {
            pre.next = null;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, current = head, next = null;
        while (null != current) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    private void merge(ListNode head1, ListNode head2) {
        boolean first = false;
        ListNode current = head1;
        head1 = head1.next;
        while (head1 != null || head2 != null) {
            if (null == head1) {
                current.next = head2;
                head2 = head2.next;
            } else if (null == head2) {
                current.next = head1;
                head1 = head1.next;
            } else {
                if (first) {
                    current.next = head1;
                    head1 = head1.next;
                } else {
                    current.next = head2;
                    head2 = head2.next;
                }
                first = !first;
            }
            current = current.next;
        }
    }


    // 这么做不如翻转第二部分的链表来的快，不知道为何
    public void reorderList(ListNode head) {
        if (null == head){
            return;
        }
        ListNode slow = head, fast = head;
        // 两个list表示间隙，给初值减少扩容损耗
        List<ListNode> from = new ArrayList<>(100);
        List<ListNode> to = new ArrayList<>(100);
        int count = 1;

        while (null != fast.next && null != fast.next.next){
            from.add(slow);
            to.add(slow.next);
            slow = slow.next;
            fast = fast.next.next;
            count += 2;
        }

        if (null != fast.next){
            count++;
        }

        ListNode firstLast = slow;
        if ((count & 1) == 0){
            from.add(slow);
            to.add(null);
        }

        ListNode current = slow.next;
        for (int i = from.size() - 1; i >= 0;i--){
            ListNode next = current.next;
            from.get(i).next = current;
            current.next = to.get(i);
            current = next;
        }

        if ((count & 1) != 0){
            firstLast.next = null;
        }

    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2; n2.next = n3; n3.next = n4;

        new Reorder_List().reorderList(n1);
    }
}
