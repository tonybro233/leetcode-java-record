package tony.leetcode.feature.dynamic_program;

// 96. 不同的二叉搜索树
// 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
// 返回满足题意的二叉搜索树的种数。

// 提示：
// 1 <= n <= 19

public class unique_binary_search_trees {

    public int numTrees(int n) {
        // 首先要意识到数量只和n有关，和具体数字无关
        // 然后要想到转移方程 某个节点为头结点的情况下，树的数量是左子树数量x右子树数量
        // 最后要发现可以从小到大进行迭代计算

        int[] D = new int[n + 1];
        D[0] = 1;
        D[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                D[i] += D[j - 1] * D[i - j];
            }
        }

        return D[n];
    }


}
