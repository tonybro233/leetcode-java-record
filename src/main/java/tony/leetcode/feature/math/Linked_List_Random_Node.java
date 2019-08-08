package tony.leetcode.feature.math;

import tony.util.ListNode;

import java.util.Random;

// 382. 链表随机节点
// 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
//
// 进阶:
// 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
//
// 示例:
// // 初始化一个单链表 [1,2,3].
// ListNode head = new ListNode(1);
// head.next = new ListNode(2);
// head.next.next = new ListNode(3);
// Solution solution = new Solution(head);
//
// getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。

public class Linked_List_Random_Node {

    private ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    // public Solution(ListNode head) {
    public Linked_List_Random_Node(ListNode head) {
        this.head = head;
    }

    // 水塘抽样算法

    /** Returns a random node's value. */
    public int getRandom() {
        int result = head.val;
        ListNode node = head.next;
        int i = 2;
        Random random = new Random();
        while (node != null){
            // 第n个数被选中的概率为 1/n, 注意被选中后还有可能被覆盖
            // 第n个数被最终选中的概率为:
            // 1/n * n/(n+1) * (n+1)/(n+2) * ... * (k-1)/k = 1/k
            if (random.nextInt(i) == 0) {
                result = node.val;
            }
            i++;
            node = node.next;
        }

        return result;
    }

}
