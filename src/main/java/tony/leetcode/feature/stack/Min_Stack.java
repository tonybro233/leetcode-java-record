package tony.leetcode.feature.stack;

// 155 最小栈
// 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
// push(x) -- 将元素 x 推入栈中。
// pop() -- 删除栈顶的元素。
// top() -- 获取栈顶元素。
// getMin() -- 检索栈中的最小元素。

// 示例:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.getMin();   --> 返回 -2.

public class Min_Stack {
    private int size;
    private node cursor;
    private node assist;

    public Min_Stack(){
        size = 0;
    }

    public void push(int i){
        if (null == cursor){
            cursor = new node(i);
            assist = new node(i);
        } else {
            cursor = new node(i, cursor);
            if (i < assist.val){
                assist = new node(i, assist); // 辅助节点（本身从大到小）
            }
        }
        size++;
    }

    public Integer pop(){
        if (size == 0){
            return null;
        }
        int re = cursor.val;
        if (cursor.val == assist.val){
            assist = assist.before;
        }
        cursor = cursor.before;
        size--;
        return re;
    }

    public int top() {
        return cursor.val;
    }

    public int getMin() {
        return assist.val;
    }

}

class node {
    public int val;
    public node before;
    public node next;

    public node(int val){
        this.val = val;
    }

    public node(int val, node before){
        this.val = val;
        this.before = before;
        before.next = this;
    }
}