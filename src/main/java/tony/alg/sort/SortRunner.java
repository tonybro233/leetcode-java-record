package tony.alg.sort;

import java.util.Arrays;
import java.util.Random;

public class SortRunner {

    /**
     * 运行时输入排序类的全类名作为参数
     */
    public static void main(String[] args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>\n");
        if (args.length == 0) {
            throw new IllegalArgumentException("Provide a sort class's full name");
        }
        System.out.println("Clazz : " + args[0] + "\n");

        Class<?> sortClazz = Class.forName(args[0]);
        Object o = sortClazz.newInstance();
        if (!(o instanceof SortBase)) {
            throw new Exception("非法类型");
        }
        SortBase<Integer> sorter = (SortBase<Integer>) o;

        Integer[] intArray = new Integer[15];
        Random ra = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = ra.nextInt(100);
        }
        System.out.println("init array :\t" + Arrays.toString(intArray));
        sorter.sort(intArray);
        System.out.print("result array :\t" + Arrays.toString(intArray));
        System.out.println();
        boolean sorted = sorter.isSorted(intArray);
        System.out.println("Is sorted : " + sorted + "\n");

        if (sorted) {
            // 性能测试
            long before = System.currentTimeMillis();
            for (int j = 0; j < 50; j++) {
                Integer[] golist = new Integer[10000];
                for (int i = 0; i < golist.length; i++) {
                    golist[i] = ra.nextInt(1000);
                }
                sorter.sort(golist);
            }
            long after = System.currentTimeMillis();
            System.out.println((after - before) + " millis used to sort 10000 sized array 50 times \n");
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
