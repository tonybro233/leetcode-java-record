package tony.leetcode.feature.bit_operation;

public class Number_Complement {

    // 476
    // 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。

    // 注意:
    // 给定的整数保证在32位带符号整数的范围内。
    // 你可以假定二进制数不包含前导零位。


    // 注意jdk Integer提供的方法
    // 获取num的比特位数n，用所有位都是1的n位 数与num进行异或运算
    public int findComplement(int num) {
        return (Integer.MAX_VALUE >>> (Integer.numberOfLeadingZeros(num)-1)) ^ num;
    }

    // highestOneBit 取 i 这个数的二进制形式最左边的最高一位且高位后面全部补零
    public int findComplement2(int num) {
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }

    public int findComplement3(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }
}
