package tony.sword_to_offer;

// 15. 二进制中1的个数
// 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
// 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

// 与Number_of_1_Bits相同

public class _15_number_of_1 {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((1 & n) == 1) {
                result++;
            }
            n >>>= 1;
        }
        return result;
    }

    public int hammingWeight2(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            // 若最右为1, 则减1正好是将最右的1变为0
            // 若最右不为1, 则最右的1变为零, 最后的1后面的0均变为1
            // 执行按位与操作，两种操作都是将最右的1变为0
            n = (n - 1) & n;
        }
        return result;
    }

}
