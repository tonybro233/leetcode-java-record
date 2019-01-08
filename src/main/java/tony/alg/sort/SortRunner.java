package tony.alg.sort;

import java.util.Random;

public class SortRunner {

    /**
     * 运行时输入排序类的全类名作为参数
     */
    public static void main(String[] args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>\n");
        if (args.length == 0) {
            throw new IllegalArgumentException("Give a sort class's full name");
        }
        System.out.println("Clazz : "+ args[0] + "\n");

        Integer[] intlist = new Integer[15];
        Random ra = new Random();
        System.out.print("init array :\t");
        for (int i = 0; i < intlist.length ; i++) {
            intlist[i] = ra.nextInt(100);
            System.out.print(intlist[i]+" ");
        }
        System.out.println("\n------Start");

        Class<?> sortClazz = Class.forName(args[0]);
        Object o = sortClazz.newInstance();
        if (! (o instanceof SortBase)){
            throw new Exception("非法类型");
        }
        SortBase<Integer> sorter = (SortBase<Integer>) o;
        sorter.sort(intlist);
        System.out.print("result array :\t");
        sorter.show(intlist);
        System.out.println();
        System.out.println("Is sorted : "+sorter.isSorted(intlist) + "\n");

        if (sorter.isSorted(intlist)){
            // 性能测试
            long before = System.currentTimeMillis();
            for (int j = 0; j < 50; j++){
                Integer[] golist = new Integer[10000];
                for (int i = 0; i < golist.length ; i++) {
                    golist[i] = ra.nextInt(1000);
                }
                sorter.sort(golist);
            }
            long after = System.currentTimeMillis();
            System.out.println((after-before)+" millis used to sort 10000 sized array 50 times \n");
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
