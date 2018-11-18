package tony.alg.sort;

public class InsertionSort<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] a) {
        for (int i = 1; i < a.length;i++){
            for (int j = i; j > 0 && a[j].compareTo(a[j-1]) < 0;j--){
                exch(a,j,j-1);
            }
        }
    }
}
