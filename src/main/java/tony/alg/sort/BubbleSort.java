package tony.alg.sort;

/**
 * 冒泡排序
 * 平均时间复杂度O(n2)
 * 属于稳定排序
 *
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] a) {
        int N = a.length;
        for (int i = N - 1; i > 0; i--) {
            boolean noChange = true;
            for (int j = 0; j < i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    exch(a, j, j + 1);
                    noChange = false;
                }
            }
            if (noChange) {
                break;
            }
        }
    }
}
