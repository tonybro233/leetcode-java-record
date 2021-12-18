import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class SleepTest {

    @Test
    public void test0() {
        // Thread.currentThread().interrupt();

        long st = System.currentTimeMillis();
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000L));
        long ed = System.currentTimeMillis();

        System.out.println("park 耗时:" + (ed - st) + "ms");
    }

    @Test
    public void test1() {
        Thread.currentThread().interrupt();

        long st = System.currentTimeMillis();
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000L));
        long ed = System.currentTimeMillis();

        System.out.println("先打断再park 耗时:" + (ed - st) + "ms");
    }

    @Test
    public void test2() {
        Thread.currentThread().interrupt();

        long st = System.currentTimeMillis();
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000L));
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000L));
        long ed = System.currentTimeMillis();

        System.out.println("先打断再2次park 耗时:" + (ed - st) + "ms");
    }

    @Test
    public void test2_2() {
        LockSupport.unpark(Thread.currentThread());

        long st = System.currentTimeMillis();
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000L));
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000L));
        long ed = System.currentTimeMillis();

        System.out.println("先unpark再2次park 耗时:" + (ed - st) + "ms");
    }


    @Test
    public void test3() {
        int iteCount = 0;
        // Thread.currentThread().interrupt();

        long st = System.currentTimeMillis();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ignore) {
            iteCount++;
        }
        long ed = System.currentTimeMillis();

        System.out.println("sleep 耗时:" + (ed - st) + "ms iteCount=" + iteCount);
    }

    @Test
    public void test4() {
        int iteCount = 0;
        Thread.currentThread().interrupt();

        long st = System.currentTimeMillis();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ignore) {
            iteCount++;
        }
        long ed = System.currentTimeMillis();

        System.out.println("先打断再sleep 耗时:" + (ed - st) + "ms iteCount=" + iteCount);
    }

    @Test
    public void test5() {
        int iteCount = 0;
        Thread.currentThread().interrupt();

        long st = System.currentTimeMillis();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ignore) {
            iteCount++;
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ignore) {
            iteCount++;
        }
        long ed = System.currentTimeMillis();

        System.out.println("先打断再2次sleep 耗时:" + (ed - st) + "ms iteCount=" + iteCount);
    }


    @Test
    public void test6() throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("我是1号");
                long st = System.currentTimeMillis();
                try {
                    lock.wait(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long ed = System.currentTimeMillis();
                System.out.println("1号等待了" + (ed - st) + "ms");
            }
        });
        t1.start();

        Thread.sleep(100);
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("我是2号");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("劳资才结束");
            }
        });
        t2.start();

        t1.join();
        t2.join();
    }

}
