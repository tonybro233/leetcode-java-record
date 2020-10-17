package tony.alg.sort;

/**
 * 归并排序
 * 平均时间复杂度O(nlogn)
 * 属于稳定排序
 * 可以优化为TimSort
 *
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] a) {
        Sort(a, 0, a.length - 1);
    }

    private void Sort(T[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        Sort(a, lo, mid);
        Sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(T[] a, int lo, int mid, int hi) {
        if (lo >= hi) {
            return;
        }
        int leftPos = lo;
        int rightPos = mid + 1;
        int len = hi - lo + 1;
        Object[] helper = new Object[len];
        int helperIdx = 0;
        while (leftPos <= mid && rightPos <= hi) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                helper[helperIdx++] = a[leftPos++];
            } else {
                helper[helperIdx++] = a[rightPos++];
            }
        }
        while (leftPos <= mid) {
            helper[helperIdx++] = a[leftPos++];
        }
        while (rightPos <= hi) {
            helper[helperIdx++] = a[rightPos++];
        }

        System.arraycopy(helper, 0, a, lo, len);
    }
}
