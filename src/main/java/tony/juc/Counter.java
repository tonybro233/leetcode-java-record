package tony.juc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private volatile AtomicInteger c = new AtomicInteger();
    private volatile int d = 0;

    public void reset(){
        c.set(0);
        d = 0;
    }

    public int getValue(){
        return c.get();
    }

    public void addThousand(){
        for (int i = 0; i < 1000;i++) {
            c.getAndIncrement();
            ++d;
        }
    }

    public void printValue(){
        System.out.println("c:"+c.get());
        System.out.println("d:"+d);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter counter = new Counter();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory());
        Collection<Callable<Object>> callables = new ArrayList<>();
        for (int i = 0;i < 100;i++){
            callables.add(() -> {
                counter.addThousand();
                return null;
            });
        }
        List<Future<Object>> futures = executor.invokeAll(callables);
        counter.printValue();
        executor.shutdown();
    }
}
