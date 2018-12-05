package tony.leetcode.feature.bit_operation;

// 371. 两整数之和
// 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
//
// 示例 1:
// 输入: a = 1, b = 2
// 输出: 3

// 示例 2:
// 输入: a = -2, b = 3
// 输出: 1

public class Sum_of_Two_Integers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int c = a ^ b; // 异或可以表示不进位的加法
            b = (a & b) << 1; // 与可以表示都是1的位置，然后右移一位表示进位数
            a = c; // 循环将加法分解为2步直到进位数为0
        }
        return a;
    }
}
