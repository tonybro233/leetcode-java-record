package tony.alg.sort;

public class QuickSort<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] a) {
        Sort(a,0,a.length-1);
    }

    private void Sort(T[] a, int lo , int hi){
        if (lo >= hi) {
            return;
        }
        int mid = partition(a,lo,hi);
        Sort(a,lo,mid-1);
        Sort(a,mid+1,hi);
    }

    private int partition(T[] a, int lo , int hi){
        int mid = (lo+hi)/2;
        T v = a[mid];
        exch(a,hi,mid);
        int pivot = lo - 1;
        for (int i = lo; i <= hi; i++){
            if (a[i].compareTo(v) <= 0){
                pivot++;
                if (i > pivot){
                    exch(a,pivot,i);
                }
            }
        }
        return pivot;
    }


}
