package tony.leetcode.feature.dynamic_program;

// 650. 只有两个键的键盘
// 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
//
// Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
// Paste (粘贴) : 你可以粘贴你上一次复制的字符。
// 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。
// 输出能够打印出 n 个 'A' 的最少操作次数。
//
// 示例 1:
// 输入: 3
// 输出: 3
// 解释:
// 最初, 我们只有一个字符 'A'。
// 第 1 步, 我们使用 Copy All 操作。
// 第 2 步, 我们使用 Paste 操作来获得 'AA'。
// 第 3 步, 我们使用 Paste 操作来获得 'AAA'。

// 说明:
// n 的取值范围是 [1, 1000] 。

public class _2_Keys_Keyboard {

    // 动态规划
    public int minSteps(int n) {
        int[] D = new int[n + 1];
        for (int i = 2;i <= n;i++) {
            for (int j = i-1; j > 0; j--) {
                if (i % j == 0) {
                    // 严格来说还是因数分解
                    // 所以最小的肯定是第一个整除然后采用paste + copy，而不可能是继续D[j]的copy
                    D[i] = D[j] + i / j; // 1次paste 加 i/j -1次copy
                    break;
                }
            }
        }
        return D[n];
    }

    // 因数分解，将n分解为m个数字的乘积 且m个数字的和最小
    public int minSteps2(int n) {
        int count = 0;

        for(int i = 2;i <= n;i++){
            while(n % i == 0){
                count += i;
                n /= i;
            }
        }
        return count;
    }
}
