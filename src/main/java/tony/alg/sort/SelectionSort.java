package tony.alg.sort;

public class SelectionSort<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n-1;i++) {
            int min = i;
            T mint = a[i];
            for (int j = i+1 ;j < n;j++) {
                if (a[j].compareTo(mint) < 0) {
                    min = j;
                    mint = a[j];
                }
            }
            exch(a,i,min);
        }
    }
}
