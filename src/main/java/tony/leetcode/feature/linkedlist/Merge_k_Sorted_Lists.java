package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

// 23. 合并K个排序链表
// 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
// 示例:
// 输入:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// 输出: 1->1->2->3->4->4->5->6

public class Merge_k_Sorted_Lists {

    /**
     * 假设k个列表，列表长度最大为n
     * 三种方法：
     * 1. 一个一个顺序合并：这个和所有链表按照head一起合并应该是一样的
     *      时间复杂度 O(k^2*n) 空间复杂度 O(1)
     * 2. 归并法：8个合成4个，4个合成2个，如此执行
     *      时间复杂度 O(kn*logk) 空间复杂度 O(logk)
     * 3. 优先队列：把所有头节点放入优先队列，然后出队，出队节点的next存入优先队列
     *      时间复杂度 O(kn*logk) 空间复杂度 O(k)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (int i = 0; i < lists.length; i++) {
            if (null != lists[i]) {
                queue.add(lists[i]);
            }
        }
        while (queue.peek() != null) {
            ListNode node = queue.poll();
            current.next = node;
            if (null != node.next) {
                queue.add(node.next);
            }
            current = current.next;
        }
        return dummy.next;
    }

    // 采用归并排序的思路
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;
        while (k > 1) {
            for (int i = 0; i < k / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[i + (k + 1) / 2]);
            }
            // 这个序列。。
            k = (k + 1) / 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 == null) {
            node.next = list2;
        }
        if (list2 == null) {
            node.next = list1;
        }
        return root.next;
    }
}
