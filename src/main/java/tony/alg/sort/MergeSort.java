package tony.alg.sort;

import java.util.LinkedList;
import java.util.Queue;

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
        Sort(a,0,a.length-1);
    }

    private void Sort(T[] a, int lo, int hi){
        if (lo >= hi){
            return;
        }
        int mid = (lo + hi)/2;
        Sort(a,lo,mid);
        Sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    private void merge(T[] a, int lo, int mid, int hi){
        if (lo >= hi){
            return;
        }
        int p = lo;
        int q = mid + 1;
        Queue<T> que = new LinkedList<>();
        T pp = null, qq = null;
        while (true){
            if (p <= mid) {
                pp = a[p];
            }
            if (q <= hi) {
                qq = a[q];
            }
            if (null == pp && null == qq) {
                break;
            }else if (null == pp){
                que.offer(qq);
                q++;
            }else if (null == qq){
                que.offer(pp);
                p++;
            }else{
                if (pp.compareTo(qq) > 0){
                    que.offer(qq);
                    q++;
                }else{
                    que.offer(pp);
                    p++;
                }
            }
            qq = null;pp = null;
        }
        int i = lo;
        for (T ea : que){
            a[i++] = ea;
        }
    }
}
