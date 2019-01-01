package tony.juc;

import java.util.concurrent.atomic.AtomicReference;

// 使用Atomic实现的简单线程安全栈

public class CocurrentStack <T> {
    private AtomicReference<Node<T>> top = new AtomicReference<>();

    public T pop(){
        Node<T> oldHead, newHead;
        do {
            oldHead = top.get(); // 取值
            if (null == oldHead){
                return null;
            }
            newHead = oldHead.next; // 计算新值
        } while (!top.compareAndSet(oldHead, newHead)); // CAS赋值
        return oldHead.item;
    }

    public void push(T item){
        Node<T> oldHead, newHead = new Node<>(item);
        do {
            oldHead = top.get();
            newHead.next = oldHead;
        } while (!top.compareAndSet(oldHead, newHead));
    }

    private static class Node<T> {
        public final T item;
        public Node<T> next;

        public Node(T item){
            this.item = item;
        }
    }
}
