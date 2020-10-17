package tony.alg.sort;

/**
 * 选择排序
 * 平均时间复杂度O(n2)
 * 属于不稳定排序
 *
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            T minVal = a[i];
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(minVal) < 0) {
                    minIdx = j;
                    minVal = a[j];
                }
            }
            exch(a, i, minIdx);
        }
    }
}
