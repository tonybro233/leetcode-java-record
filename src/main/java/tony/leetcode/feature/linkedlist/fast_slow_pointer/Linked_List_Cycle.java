package tony.leetcode.feature.linkedlist.fast_slow_pointer;

import tony.util.ListNode;

import java.util.HashSet;
import java.util.Set;

// 141 环形链表
// 给定一个链表，判断链表中是否有环。
//
// 进阶：
// 你能否不使用额外空间解决此题？

public class Linked_List_Cycle {

    // 最基本的使用Set来记录节点
    public boolean hasCycle(ListNode head) {
        ListNode now = head;
        Set<ListNode> record = new HashSet<>();
        while (now != null) {
            if (record.contains(now)) {
                return true;
            }
            record.add(now);
            now = now.next;
        }
        return false;
    }

    // 不使用额外空间
    // 使用快慢指针来校验，快指针每一步走2次，慢指针走1次，如果有环，快指针必定能追上慢指针
    public boolean hasCycle2(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null && fast.next.next != null) {
            if (fast.equals(slow)) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
