package tony.sword_to_offer;

// 64. 求1+2+…+n
// 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

public class _64_sum_nums {

    // 应该是有比较复杂的移位运算解法
    public int sumNums(int n) {
        return fuckingCrazy(new int[n], n);
    }

    private int fuckingCrazy(int[] arr, int n) {
        try {
            arr[n - 1] = n;
            return n + fuckingCrazy(arr, n - 1);
        } catch (ArrayIndexOutOfBoundsException ignore) {
            return 0;
        }
    }

}
