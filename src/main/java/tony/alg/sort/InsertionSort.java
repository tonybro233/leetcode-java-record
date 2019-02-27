package tony.alg.sort;

/**
 * 插入排序
 * 平均时间复杂度O(n2)
 * 属于稳定排序
 *
 * @param <T>
 */
public class InsertionSort<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] a) {
        for (int i = 1; i < a.length;i++){
            T tmp = a[i];
            int j = i;
            for ( ; j > 0 && a[j-1].compareTo(tmp) > 0;j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }
}
