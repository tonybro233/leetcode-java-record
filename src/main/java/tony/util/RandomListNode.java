package tony.util;

/**
 * The random linked list is a singly linked list given
 * such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 *
 */
public class RandomListNode {

    public int label;

    public RandomListNode next;

    public RandomListNode random;

    /**
     * Constructor
     * @param x input label value
     */
    public RandomListNode(int x) {
        label = x;
    }

    /**
     * Serialization
     */
    @Override
    public String toString() {
        RandomListNode cur = this;
        String str = "";
        while (cur != null) {
            str += cur.label;
            if (cur.next != null) {
                str += ("[" + cur.random.label + "]");
                str += "->";
            } else {
                str += "[null]";
            }
            cur = cur.next;
        }
        return str;
    }

}
