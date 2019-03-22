package tony.codewar.linkedlist;

// You are given a node that is the beginning of a linked list.
// This list always contains a tail and a loop.
//
// Your objective is to determine the length of the loop.

public class LoopInspector {

    public int loopSize(Node node) {
        // 快慢指针找到环内的某节点
        Node slow = node, fast = node;
        do {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        } while (slow != fast);

        Node n = slow;
        int result = 0;
        // 环遍历
        do {
            n = n.getNext();
            result++;
        } while (n != slow);

        return result;
    }

    private class Node {
        private int val;
        private Node next;
        public Node getNext(){
            return next;
        }
    }
}
