package tony.alg.sort;

public class ShellSort<T extends Comparable<T>> extends SortBase<T> {
    @Override
    public void sort(T[] a) {
        int N = a.length;
        int h = 1;

        // 使用了序列1/2(3的k次-1)，这个序列有点骚
        // 采用如下的序列形式（倒序遍历h），使得数组在每次循环中，每间隔h的对象进行插入排序，最后h为1，等价为一次插入排序
        // 不好理解的地方在于虽然第一层for循环执行次数是 length - h ，但是是对length / h 个子序列进行了排序操作

        // h表示的是每个子序列元素的间隔

        // 计算出h的起始值
        while (h < N/3) {
            h = h*3 +1; // 1, 4, 13, 40, 121, ... 序列形式
        }


        while (h >= 1) {
            // 一个两重循环，排序了 length/h 个子序列，h~n-1个元素都按照递减规则分配到的子序列参与了排序
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j].compareTo(a[j-h]) < 0;j -= h) {
                    exch(a, j, j-h);
                }
            }

            h = h/3; // 对应序列生成方式
        }
    }
}
