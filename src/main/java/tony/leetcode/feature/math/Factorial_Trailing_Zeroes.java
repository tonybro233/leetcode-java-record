package tony.leetcode.feature.math;

// 172. 阶乘后的零
// 给定一个整数 n，返回 n! 结果尾数中零的数量。
//
// 示例 1:
// 输入: 3
// 输出: 0
// 解释: 3! = 6, 尾数中没有零。

// 示例 2:
// 输入: 5
// 输出: 1
// 解释: 5! = 120, 尾数中有 1 个零.
// 说明: 你算法的时间复杂度应为 O(log n) 。

public class Factorial_Trailing_Zeroes {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0){
            n = n / 5; // 被5、25、125整除的个数
            count += n;
        }
        return count;
    }

    public int trailingZeroes2(int n) {
        int count = 0;
        int val = 1;
        int p1 = 1, p2 = 1;
        int tcount = 0;
        int fcount = 0;
        // 只考虑5就可以，2的因子必然比5多
        for (int i = 1; i <= n;i++){
            p1 = i;p2 = i;
            while (p1 % 2 == 0){
                tcount++;
                p1 = p1 / 2;
            }
            while (p2 % 5 == 0){
                fcount++;
                p2 = p2 / 5;
            }
        }
        return tcount > fcount? fcount : tcount;
    }

    public int trailingZeroes1(int n) {
        int count = 0;
        int val = 1;
        int p = 1;
        for (int i = 1; i <= n;i++){
            p = i;
            while(p % 10 == 0){
                count++;
                p = p /10;
            }
            val *= p;
            if (val % 10 == 0){
                val = val/10;
                count++;
            }
            else{
                val = val % 100;
            }
        }
        return count;
    }
}
