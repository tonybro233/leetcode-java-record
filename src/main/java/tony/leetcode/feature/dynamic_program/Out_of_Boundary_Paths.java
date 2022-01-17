package tony.leetcode.feature.dynamic_program;

// 576. 出界的路径数
// 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，
// 或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。
// 找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。

// 说明:
// 球一旦出界，就不能再被移动回网格内。
// 网格的长度和高度在 [1,50] 的范围内。
// N 在 [0,50] 的范围内。

import java.util.HashMap;
import java.util.Map;

public class Out_of_Boundary_Paths {

    public int findPaths(int m, int n, int N, int i, int j) {
        int result = 0;
        int mod = 10_0000_0007;
        int[][] grid = new int[m][n];
        grid[i][j] = 1;

        // 原始方法，每个节点都影响下一步周边的4个节点
        for (int k = 0; k < N; k++){
            int[][] tmp = new int[m][n];
            for (int I = 0; I < m;I++){
                for (int J = 0; J < n;J++){
                    try {
                        tmp[I][J-1] += grid[I][J];
                        tmp[I][J-1] %= mod;
                    } catch (ArrayIndexOutOfBoundsException ignore){
                        result += grid[I][J];
                        result %= mod;
                    }
                    try {
                        tmp[I][J+1] += grid[I][J];
                        tmp[I][J+1] %= mod;
                    } catch (ArrayIndexOutOfBoundsException ignore){
                        result += grid[I][J];
                        result %= mod;
                    }
                    try {
                        tmp[I-1][J] += grid[I][J];
                        tmp[I-1][J] %= mod;
                    } catch (ArrayIndexOutOfBoundsException ignore){
                        result += grid[I][J];
                        result %= mod;
                    }
                    try {
                        tmp[I+1][J] += grid[I][J];
                        tmp[I+1][J] %= mod;
                    } catch (ArrayIndexOutOfBoundsException ignore){
                        result += grid[I][J];
                        result %= mod;
                    }
                }
            }
            grid = tmp;
        }

        return result;
    }



    static int MOD=(int)Math.pow(10,9)+7;

    public int findPaths2(int m, int n, int N, int i, int j) {
        // 动态规划, dp[i][j][k]表示从(i, j)开始在k步内移除边界的路径数.
        // 可知dp[i][j][k]只与(i, j)四周邻接点在k-1步内移除边界的路径数有关.
        // dp[i][j][k] = dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j-1][k-1] + dp[i][j+1][k-1];
        // 空间优化: 可以看出重复利用一个二维数组储存路径数即可(k-1步更新之后就无需保存)
        int [][][] dp = new int[m][n][N+1];
        for (int a = 0;a < m;a++){
            for (int b = 0;b < n;b++){
                for (int c = 0;c < N+1;c++){
                    dp[a][b][c]=-1;
                }
            }
        }
        return find(dp,m,n,N,i,j);
    }

    private int find(int[][][] dp, int m, int n, int num, int i, int j){
        if (i<0 || j<0 || i>=m || j>=n) {
            return 1;
        }
        if (num == 0) {
            return 0;
        }
        if (dp[i][j][num] != -1) {
            return dp[i][j][num];
        }
        dp[i][j][num]=(
                (find(dp,m,n,num-1,i+1,j) + find(dp,m,n,num-1,i-1,j)) % MOD +
                (find(dp,m,n,num-1,i,j+1)+ find(dp,m,n,num-1,i,j-1)) % MOD
        ) % MOD;

        return dp[i][j][num];
    }

    public int findPaths3(int m, int n, int N, int i, int j) {
        int mod = 1000000007;
        int[][] dp = new int[m][n]; // 保存第k步的结果
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 由边界节点作为最后一步，每个节点都由后一步的四个周边节点之和得出，因此相比较原始方法更快
        for(int k = 1; k <= N; ++k) {
            int[][] temp = new int[m][n]; // 保存第k-1步的结果
            for(int x = 0; x < m; ++x) {
                for(int y = 0; y < n; ++y) {
                    for(int[] dir : dirs) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            temp[x][y] += 1;
                        } else {
                            temp[x][y] = (dp[nx][ny] + temp[x][y]) % mod;
                        }
                    }
                }
            }
            dp = temp;
        }

        return dp[i][j];
    }

    Map<Integer, Integer> cache = new HashMap<>();
    int[][] DIRs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 记忆化搜索
    public int findPaths4(int m, int n, int N, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }

        if (N == 0) {
            return 0;
        }

        // 核心还是 位置+剩余步数 可以组成一个key
        // 直接利用了题目限定条件做类似位运算的操作
        int key = i * 2500 + j * 50 + N;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int rst = 0;
        for (int[] dir : DIRs) {
            rst = (rst + findPaths4(m, n, N - 1, i + dir[0], j + dir[1])) % MOD;
        }

        cache.put(key, rst);

        return rst;
    }

}
