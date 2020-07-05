package tony.sword_to_offer;

// 49. 丑数
// 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
// 示例:
// 输入: n = 10
// 输出: 12
// 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
// 1 是丑数。
// n 不超过1690。

public class _49_ugly_number {

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        int[] D = new int[n];
        D[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;

        for (int i = 1; i < n;i++) {
            int v2 = D[idx2] * 2;
            int v3 = D[idx3] * 3;
            int v5 = D[idx5] * 5;

            D[i] = Math.min(v2, Math.min(v3, v5));

            // 注意这里不能用 else ，防止重复值
            if (D[i] == v2) {
                idx2++;
            }
            if (D[i] == v3) {
                idx3++;
            }
            if (D[i] == v5) {
                idx5++;
            }
        }

        return D[n - 1];
    }

}
