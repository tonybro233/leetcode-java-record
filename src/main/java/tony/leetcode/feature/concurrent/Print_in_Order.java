package tony.leetcode.feature.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

// 1114. 按序打印
// 我们提供了一个类：
// public class Foo {
//   public void one() { print("one"); }
//   public void two() { print("two"); }
//   public void three() { print("three"); }
// }

// 三个不同的线程将会共用一个 Foo 实例。
//
// 线程 A 将会调用 one() 方法
// 线程 B 将会调用 two() 方法
// 线程 C 将会调用 three() 方法
// 请设计修改程序，以确保 two()方法在one()方法之后被执行，three()方法在two()方法之后被执行。

public class Print_in_Order {

    private AtomicInteger atom ;

    // public Foo() {
    public Print_in_Order() {
        atom = new AtomicInteger(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (!atom.compareAndSet(0, 1)) {
            Thread.sleep(1);
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!atom.compareAndSet(1, 2)) {
            Thread.sleep(1);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!atom.compareAndSet(2, 3)) {
            Thread.sleep(1);
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
