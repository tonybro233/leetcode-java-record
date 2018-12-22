package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

import java.util.*;

// 148. 排序链表
// 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
// 示例 1:
// 输入: 4->2->1->3
// 输出: 1->2->3->4

// 示例 2:
// 输入: -1->5->3->4->0
// 输出: -1->0->3->4->5

public class Sort_List {

    // 归并排序
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针求取中间节点
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode a = sortList2(head);
        ListNode b = sortList2(slow);
        return merge(a, b);

    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (a != null && b != null) {
            if (a.val >= b.val) {
                p.next = b;
                b = b.next;
            }else{
                p.next = a;
                a = a.next;
            }
            p = p.next;
        }
        if (a != null) {
            p.next = a;
        }
        if (b != null) {
            p.next = b;
        }
        return head.next;
    }

    // 借助辅助集合排序
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while (current != null){
            list.add(current);
            current = current.next;
        }
        if (list.size() == 0){
            return null;
        }
        list.sort(Comparator.comparingInt(node -> node.val));
        for (int i = 0; i < list.size() - 1;i++){
            list.get(i).next = list.get(i+1);
        }
        list.get(list.size()-1).next = null; // 不要忘了这步
        return list.get(0);
    }
}
