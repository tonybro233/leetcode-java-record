package tony.alg;

/**
 * 链表翻转
 */
public class ChainReverse {

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two; two.next = three; three.next = four; four.next = five;
        ListNode head = inverseRecur(one);
        printList(head);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /** 迭代方式 */
    public static ListNode inverse(ListNode head){
        ListNode tmp = new ListNode(0);
        while (head != null){
            ListNode next = head.next;
            head.next = tmp.next;
            tmp.next = head;
            head = next;
        }
        return tmp.next;
    }

    /** 递归方式 */
    public static ListNode inverseRecur(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode result = inverseRecur(next);
        next.next = head;
        head.next = null;

        return result;
    }

    public static void printList(ListNode head){
        System.out.print("begin: ");
        while (head != null ){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println("End");
    }
}