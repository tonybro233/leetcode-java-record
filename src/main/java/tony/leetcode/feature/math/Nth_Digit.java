package tony.leetcode.feature.math;

// 400. 第N个数字
// 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
//
// 注意:
// n 是正数且在32位整形范围内 ( n < 231)。
//
// 示例 1:
// 输入:
// 3
//
// 输出:
// 3

// 示例 2:
// 输入:
// 11
//
// 输出:
// 0
// 说明:
// 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。

public class Nth_Digit {

    public int findNthDigit(int n) {
        long nn = n;
        long l = 1; // 到达n位数字
        long c = 9; // x位数字的数量
        long lastBegin = 0; // 最后一位n-1位数
        long lastPos = nn; // 距离最后一位n-1位数的差
        // 最后一次c*l可能越界
        while (nn - c*l > 0){
            lastPos = nn - c*l;
            nn = lastPos;
            lastBegin += c;
            c *= 10;
            l++;
        }
        long move = lastPos / l;
        int inside = (int) (lastPos % l);
        if (inside == 0){
            String str = Long.toString(lastBegin + move);
            return str.charAt(str.length()-1) - '0';
        } else {
            return Long.toString(lastBegin+move+1).charAt(inside-1) - '0';
        }
    }

    public static void main(String[] args){
        int nthDigit = new Nth_Digit().findNthDigit(2147483647);
        System.out.println(nthDigit);
    }
}
