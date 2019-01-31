package tony.leetcode.feature.bit_operation;

// 201. 数字范围按位与
// 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
// 返回此范围内所有数字的按位与（包含 m, n 两端点）。
//
// 示例 1:
// 输入: [5,7]
// 输出: 4

// 示例 2:
// 输入: [0,1]
// 输出: 0

public class Bitwise_AND_of_Numbers_Range {

    public int rangeBitwiseAnd(int m, int n) {
        // 两个相邻的数按位与，第一位必然是0，因此只要m，n不相等，就可以都右移递归运算，然后左移
        return (m == n || m == 0) ? m : rangeBitwiseAnd(m >> 1, n >> 1) << 1;
    }
}
