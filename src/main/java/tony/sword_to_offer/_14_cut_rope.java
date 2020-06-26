package tony.sword_to_offer;

// 14. 剪绳子
// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
// 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
// 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
// 示例 1：
// 输入: 2
// 输出: 1
// 解释: 2 = 1 + 1, 1 × 1 = 1

// 示例 2:
// 输入: 10
// 输出: 36
// 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

// 提示：
// 2 <= n <= 58

// 与Integer_Break相同

public class _14_cut_rope {


    public int cuttingRope(int n) {
        // 2,3 拆分的乘积最大值比自己小，所以要单独列出
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int[] D = new int[n + 1];
        D[1] = 1;
        D[2] = 2;
        D[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i;j++) {
                D[i] = Math.max(D[i], D[j] * (i - j));
            }
        }

        return D[n];
    }

}
