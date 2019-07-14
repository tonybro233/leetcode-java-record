package tony.leetcode.feature.concurrent;

// 1115. Print FooBar Alternately

public class Print_FooBar_Alternately {

    private int n;

    private volatile boolean flag = false;

    // public FooBar(int n) {
    public Print_FooBar_Alternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag){}
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag){}
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = false;
        }
    }
}
