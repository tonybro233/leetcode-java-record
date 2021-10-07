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
}
