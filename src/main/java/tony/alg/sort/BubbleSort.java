package tony.alg.sort;

public class BubbleSort<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] a) {
        int N = a.length;
        for (int i = N-1 ; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (a[j].compareTo(a[j+1]) > 0){
                    exch(a,j,j+1);
                }
            }
        }
    }
}
