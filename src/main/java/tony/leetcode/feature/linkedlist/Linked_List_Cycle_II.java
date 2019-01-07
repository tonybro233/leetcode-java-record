package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

import java.util.HashSet;
import java.util.Set;

// 142. 环形链表 II
// 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
// 如果 pos 是 -1，则在该链表中没有环。
//
// 说明：不允许修改给定的链表。

// 进阶：
// 你是否可以不用额外空间解决此题？

public class Linked_List_Cycle_II {

    public ListNode detectCycle(ListNode head) {
        if (null == head){
            return null;
        }
        ListNode slow = head, fast = head;
        boolean got = false;
        // 快慢指针确定是否有环
        while (slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)){
                got = true;
                break;
            }
        }

        if (!got){
            return null;
        }

        // 头部到入环点相距A，入环点距离快慢指针交点距离为B
        // 相遇时慢指针走了A+B，快指针走了2（A+B），因此慢指针再走A+B就能回到交点
        // 再用一个从头开始的指针和慢指针一起走A，就会在入环点相交（A+B-B）
        ListNode tmp = head;
        while(tmp != slow){
            tmp = tmp.next;
            slow = slow.next;
        }
        return tmp;
    }

    // 不知是给hash方法下药了还是OJ判断了Set，给出超时
    public ListNode detectCycle2(ListNode head) {
        if (null == head){
            return null;
        }
        Set<ListNode> record = new HashSet<>();
        record.add(head);
        while (head.next != null){
            head = head.next;
            if (record.contains(head)){
                return head;
            }
        }

        return null;
    }
}
