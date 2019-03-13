package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 86. 分隔链表
// 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
// 你应当保留两个分区中每个节点的初始相对位置。
//
// 示例:
// 输入: head = 1->4->3->2->5->2, x = 3
// 输出: 1->2->2->4->3->5

public class Partition_List {

    // 我特么。。
    public ListNode partition(ListNode head, int x) {
        ListNode pointer = new ListNode(0);
        pointer.next = head;
        while (pointer.next != null && pointer.next.val < x){
            pointer = pointer.next;
        }
        if (pointer.next == null){
            return head;
        }
        ListNode wall = pointer.next;
        boolean isHead = pointer.next == head;
        ListNode newHead = null;

        ListNode current = pointer.next;
        ListNode before = null;
        while (current != null){
            ListNode next = current.next;
            if (current.val < x) {
                if (isHead && null == newHead){
                    newHead = current;
                }
                pointer.next = current;
                current.next = wall;
                pointer = current;
            } else {
                before = current;
            }
            if (null != before){
                before.next = next;
            }
            current = next;
        }

        if (null != newHead){
            return newHead;
        } else {
            return head;
        }
    }

    // 直接重构链表，分别构建小于x的链表和大于等于x的链表，然后连起来
    public ListNode partition2(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1); n1.next = n2;
        // ListNode n3 = new ListNode(3); n2.next = n3;
        // ListNode n4 = new ListNode(2); n3.next = n4;
        // ListNode n5 = new ListNode(5); n4.next = n5;
        // ListNode n6 = new ListNode(2); n5.next = n6;


        new Partition_List().partition(n1, 2);
    }
}
