package tony.sword_to_offer;

// 65. 不用加减乘除做加法
// 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

public class _65_add {

    // 递归只需要一行
    public int add(int a, int b) {
        int sum, carry;

        do {
            // 异或 可以代表二进制不带进位的相加结果
            sum = a ^ b;
            // 只有1 1 产生进位，即与操作然后右移1位
            carry = (a & b) << 1;
            // 不带进位的结果与进位相加，循环表示
            a = sum;
            b = carry;
        } while (b != 0);

        return a;
    }

}
