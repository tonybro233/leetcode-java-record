package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 61. 旋转链表
// 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
// 输入: 1->2->3->4->5->NULL, k = 2
// 输出: 4->5->1->2->3->NULL
// 解释:
// 向右旋转 1 步: 5->1->2->3->4->NULL
// 向右旋转 2 步: 4->5->1->2->3->NULL

// 示例 2:
// 输入: 0->1->2->NULL, k = 4
// 输出: 2->0->1->NULL
// 解释:
// 向右旋转 1 步: 2->0->1->NULL
// 向右旋转 2 步: 1->2->0->NULL
// 向右旋转 3 步: 0->1->2->NULL
// 向右旋转 4 步: 2->0->1->NULL

public class Rotate_List {

    public ListNode rotateRight2(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        // 统计长度
        int cnt = 0;
        ListNode tmp = head;
        while (tmp != null) {
            cnt++;
            tmp = tmp.next;
        }
        int mov = k % cnt;
        if (mov == 0) {
            return head;
        }
        // 找到新的头节点前一个节点以及尾节点
        ListNode preHead = null, tail = null;
        ListNode slow = head, fast = head;
        for (int i = 0; i < mov; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            preHead = slow;
            slow = slow.next;
            tail = fast;
            fast = fast.next;
        }
        // 链表调整
        tail.next = head;
        ListNode newHead = preHead.next;
        preHead.next = null;
        return newHead;
    }

    public ListNode rotateRight(ListNode head, int k) {
        // 注意空节点和单节点
        if (k == 0 || null == head || head.next == null){
            return head;
        }
        int size = 0;
        ListNode tmp = head;
        ListNode oldEnd = null;
        while (tmp != null){
            if (tmp.next == null){
                oldEnd = tmp;
            }
            size++;
            tmp = tmp.next;
        }
        k %= size;
        // 注意整除
        if (k == 0){
            return head;
        }
        ListNode breakNode = head;
        ListNode newEnd = null;
        int left = size - k;
        while (left > 0){
            if (left == 1){
                newEnd = breakNode;
            }
            left--;
            breakNode = breakNode.next;
        }
        oldEnd.next = head;
        newEnd.next = null;
        return breakNode;
    }
}
