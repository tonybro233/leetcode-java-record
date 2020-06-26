package tony.sword_to_offer;

// 16. 数值的整数次方
// 实现函数double Power(double base, int exponent)，求base的exponent次方。
// 不得使用库函数，同时不需要考虑大数问题。

// 说明:
//
// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

public class _16_pow {

    public double myPow(double x, int n) {
        // 0的0次方没有意义
        if (n == 0) {
            return 1;
        }
        if (x == 0.0) {
            return 0;
        }
        if (x == 1.0) {
            return 1.0;
        }

        // leetcode 测试用例 2.0, -2147483648 ，因此改成long
        double result = powWithPositive(x, Math.abs((long) n));
        return n < 0 ? 1.0 / result : result;
    }

    private double powWithPositive(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double result = powWithPositive(x, n >> 1);
        result *= result;
        if ((n & 1) != 0) {
            result *= x;
        }
        return result;
    }

}
