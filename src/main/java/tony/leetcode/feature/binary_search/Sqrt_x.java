package tony.leetcode.feature.binary_search;

// 69. x 的平方根
// 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
// 示例 1：
// 输入：x = 4
// 输出：2

// 示例 2：
// 输入：x = 8
// 输出：2
// 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//  
// 提示：
// 0 <= x <= 231 - 1

public class Sqrt_x {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }

        int low = 1, high = x / 2 + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long val = (long) mid * mid;
            if (val > x) {
                high = mid - 1;
            } else if (val == x) {
                return mid;
            } else if (val < x) {
                low = mid + 1;
            }
        }

        return high;
    }

}
