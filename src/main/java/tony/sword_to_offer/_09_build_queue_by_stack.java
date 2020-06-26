package tony.sword_to_offer;

import java.util.ArrayDeque;
import java.util.Deque;

// 09. 用两个栈实现队列
// 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
// 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
// 示例 1：
// 输入：
// ["CQueue","appendTail","deleteHead","deleteHead"]
// [[],[3],[],[]]
// 输出：[null,null,3,-1]

// 示例 2：
// 输入：
// ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
// [[],[],[5],[2],[],[]]
// 输出：[null,-1,null,null,5,2]

// 提示：
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用

public class _09_build_queue_by_stack {

    public static class CQueue {

        private Deque<Integer> stack1;

        private Deque<Integer> stack2;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            stack1.addLast(value);
        }

        public int deleteHead() {
            if (null != stack2.peekFirst()) {
                return stack2.pollFirst();
            } else if (null != stack1.peekFirst()) {
                while (null != stack1.peekFirst()) {
                    stack2.addLast(stack1.pollFirst());
                }
                return stack2.pollFirst();
            } else {
                return -1;
            }
        }

    }

}
