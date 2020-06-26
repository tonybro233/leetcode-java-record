package tony.sword_to_offer;

import tony.util.ListNode;

// 06. 从尾到头打印链表
// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 示例 1：
//
// 输入：head = [1,3,2]
// 输出：[2,3,1]
//  
// 限制：
// 0 <= 链表长度 <= 10000

public class _06_reverse_print_list {

    // 返回的是数组，那么就没法一趟解决
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (null != node) {
            count++;
            node = node.next;
        }

        int[] result = new int[count];
        node = head;
        while (--count >= 0) {
            result[count] = node.val;
            node = node.next;
        }

        return result;
    }

}
