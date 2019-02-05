package tony.alg.sort;

// 二叉堆形状标准，可以用数组来表示，从上到下从左到右存入数组
// 位置为K的节点，其父节点K/2向下取整，子节点为2K和2K+1
// 注意位置为K的节点下标为K-1

/**
 * 堆排序
 * 时间复杂度O(nlogn)
 * 属于不稳定排序
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] a) {
        int N = a.length;
        // 使用下沉让数组堆有序（大根）
        for (int i = (N-1)/2-1; i >= 0;i--){
            sink(a, i, N);
        }

        // 不断取出根节点放到尾部
        while (N > 1){
            exch(a, 0, --N);
            sink(a, 0, N);
        }
    }

    /**
     * 下沉操作，将指定位置的元素按照堆有序的目标下沉
     * @param a 数组
     * @param pos 元素位置
     * @param limit 下沉位置上限（本身不包含）
     */
    private void sink(T[] a, int pos, int limit){
        while (2 * (pos + 1) - 1 < limit){
            int next = 2 * (pos + 1) - 1;
            if (next + 1 < limit && a[next].compareTo(a[next+1]) < 0){
                next++;
            }
            if (a[pos].compareTo(a[next]) < 0){
                exch(a, pos, next);
                pos = next;
            } else {
                break;
            }
        }
    }

    /**
     * 堆的上浮操作
     * @param a 数组
     * @param pos 元素位置
     */
    private void swim(T[] a, int pos){
        while ((pos+1)/2-1 >= 1){
            int next = (pos+1)/2-1;
            if (a[pos].compareTo(a[next]) > 0){
                exch(a, pos, next);
            }
            pos = next;
        }
    }
}
