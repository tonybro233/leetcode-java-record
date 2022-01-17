package tony.sword_to_offer;

// 44. 数字序列中某一位的数字
// 数字以0123456789101112131415…的格式序列化到一个字符序列中。
// 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
//
// 请写一个函数，求任意第n位对应的数字。
//
// 示例 1：
// 输入：n = 3
// 输出：3

// 示例 2：
// 输入：n = 11
// 输出：0

public class _44_nth_digit {

    public int findNthDigit(int n) {
        // 1 - 9 (特殊处理，不用 0 - 9)
        // 10 - 99
        // 100 - 999
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        // 当前位数
        int digits = 1;
        // 当前位数下能够容纳的阿拉伯数字个数
        long left = 9;
        // 当前位数下起始的数子
        long start = 1;

        while (n > left) {
            n -= left;
            digits++;
            start *= 10;
            left = start * 9 * digits; // 1*9*1 10*9*2 100*9*3 1000*9*4
        }

        // 剩下n个数字，此时位数为digits，如果n=digits，那么还是在第一个数字
        // 也就是start，所以是(n - 1) / digits
        // 0也是满足的
        long num = start + (n - 1) / digits;

        // chartAt是从0开始计数，如果n=digits，就是第一个数字的最后一位
        // 而要取最后一位下标就是n-1，所以是(n - 1) % digits
        return Long.toString(num).charAt((n - 1) % digits) - '0';
    }

    // 当时思路，在大于9时可计算出正确值，小于等于9则错误，少1
    public int findNthDigit2(int n) {
        int digits = 1;
        int low = 1;
        while (true) {
            int nextLow = low + digits * 9 * (int) Math.pow(10, digits - 1);
            if (n < nextLow) {
                int effective = n + 1 - low; // 第n位是第n+1个数字, 表示剩下多少个数字
                int idx = effective / digits; // 第idx个数，从0开始
                int remain = effective % digits; // 余数
                int number = (int) Math.pow(10, digits - 1) + idx; // 第0个数是起始值
                return (number / (int) Math.pow(10, digits - remain)) % 10;
            } else {
                low = nextLow;
                digits++;
            }
        }
    }

    public static void main(String[] args) {
        _44_nth_digit calculator = new _44_nth_digit();
        int digit = calculator.findNthDigit2(11);
        System.out.println(digit);

        System.out.println(calculator.findNthDigit(4) == calculator.findNthDigit2(4));
        System.out.println(calculator.findNthDigit(9) == calculator.findNthDigit2(9));
        System.out.println(calculator.findNthDigit(10) == calculator.findNthDigit2(10));
        System.out.println(calculator.findNthDigit(998) == calculator.findNthDigit2(998));
    }

}
