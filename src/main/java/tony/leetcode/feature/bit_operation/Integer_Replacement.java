package tony.leetcode.feature.bit_operation;

// 397. 整数替换
// 给定一个正整数 n，你可以做如下操作：
// 1. 如果 n 是偶数，则用 n / 2替换 n。
// 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
// n 变为 1 所需的最小替换次数是多少？
//
// 示例 1:
// 输入:
// 8
// 输出:
// 3
// 解释:
// 8 -> 4 -> 2 -> 1

// 示例 2:
// 输入:
// 7
// 输出:
// 4
// 解释:
// 7 -> 8 -> 4 -> 2 -> 1
// 或
// 7 -> 6 -> 3 -> 2 -> 1

public class Integer_Replacement {

    // 保持二进制表达式中的1最少
    // 不知怎么的超时了几次？？
    public int integerReplacement2(int n) {
        int result = 0;
        while (n != 1){
            result++;
            if ((n & 1) == 0){
                n >>>= 1;
            } else if (n != 3 && (n & 3) == 3){
                // 注意3是个例外
                ++n;
            } else{
                --n;
            }
        }
        return result;
    }

    //
    public int integerReplacement(int n) {
        int result = 0;
        while (n != 1){
            if (Integer.bitCount(n) == 1){
                return Integer.numberOfTrailingZeros(n) + result;
            }
            if ((n & 1) == 0){
                n >>>= 1;
            } else if (n != 3 && (n & 3) == 3){
                // 注意3是个例外
                n += 1;
            } else{
                n -= 1;
            }
            result++;
        }
        return result;
    }

    // stackoverflow
    public int integerReplacement3(int n) {
        if ((n & 1) == 0){
            return integerReplacement3(n >>> 1) + 1;
        }
        return Math.min(integerReplacement3(n-1), integerReplacement3(n+1)) + 1;
    }

}
