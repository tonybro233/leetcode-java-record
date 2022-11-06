import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class LambdaTest {


    public static void main(String[] args) throws Exception {
        // m1();
        // m2();
        // pStream();

        // ExecutorService executorService = Executors.newFixedThreadPool(5);
        // executorService.submit(() -> pStream()).get();
        // executorService.shutdown();

        new ForkJoinPool(5).submit(LambdaTest::pStream).get();
    }

    public static void m1() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.forEach(System.out::println);
    }

    public static void m2() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.forEach(l -> System.out.println(l));
    }

    public static void pStream() {
        System.out.println("Processor count: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Common Fork join pool size: " + ForkJoinPool.commonPool().getParallelism());
        long start = System.currentTimeMillis();
        int res = IntStream.range(1, 10)
                .parallel()
                .map(i -> {
                    System.out.println(i + " Current thread is " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                })
                .sum();
        long end = System.currentTimeMillis();
        System.out.println("Over result=" + res + " using time: " + (end - start) + "ms");
    }

}
