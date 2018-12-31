package tony.leetcode.feature.dynamic_program;

// 552
// 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。
// 答案可能非常大，你只需返回结果mod 109 + 7的值。

// 学生出勤记录是只包含以下三个字符的字符串：
//
// 'A' : Absent，缺勤
// 'L' : Late，迟到
// 'P' : Present，到场
// 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。

// 输入: n = 2
// 输出: 8
// 解释：
// 有8个长度为2的记录将被视为可奖励：
// "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
// 只有"AA"不会被视为可奖励，因为缺勤次数超过一次。

// 注意：n 的值不会超过100000。

public class Student_Attendance_Record_II {

    /**
     * 推断所有没有A的合法组合 ：D[i] = D[i-1] + D[i-2] + D[i-3] ——> 结尾只能是P，PL，PLL
     * 加上A，以A为边界，两边就都是符合上述的组合 ... A ... 可以得出带A的组合数量为：
     * 求和{ D[i]*D[n-1-i], i = 0 ~ n-1 }
     * sum[n] = D[n-1] + D[n-2] + D[n-3] + 求和{ D[i]*D[n-1-i], i = 0 ~ n-1 }
     */
    public int checkRecord(int n) {
        if (n == 1) {
            return 3;
        } else if (n == 2) {
            return 8;
        }
        int mode = 1000000007;
        // 我日特么这都能超过int范围
        long[] D = new long[n + 1];
        D[0] = 1;
        D[1] = 2;
        D[2] = 4;
        for (int i = 3; i <= n;i++){
            D[i] = (D[i-1] + D[i-2] + D[i-3]) % mode;
        }
        long result = D[n] ;
        for (int i = 0; i < n;i++){
            result += (D[i]*D[n-1-i])%mode;
            result %= mode;
        }
        return (int) result;
    }
}
