package tony.leetcode.feature.math;

// 326. 3的幂
// 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
//
// 示例 1:
// 输入: 27
// 输出: true

// 示例 2:
// 输入: 0
// 输出: false

// 进阶：
// 你能不使用循环或者递归来完成本题吗？

public class Power_of_Three {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        // 数论的知识，3的幂次的质因子只有3，而所给出的n如果也是3的幂次，
        // 整数范围内最大的3的幂次的因子只能是3的幂次，即1162261467，3的19次幂
        int max = (int) Math.pow(3, (int) (Math.log(0x7fffffff) / Math.log(3))); // 求出整数范围内最大的3次幂
        // int max = 1162261467;
        return (max % n == 0);
    }
}
