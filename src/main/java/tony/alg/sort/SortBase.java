package tony.alg.sort;

public abstract class SortBase<T extends Comparable<T>> {

    /**
     * 执行排序
     */
    public abstract void sort(T[] a);

    /**
     * 是否有序(升序)
     */
    public boolean isSorted(T[] a){
        for (int i = 1; i < a.length;i++){
            if (a[i].compareTo(a[i-1]) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印
     */
    public void show(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 交换位置
     */
    protected void exch(T[] a, int i, int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
