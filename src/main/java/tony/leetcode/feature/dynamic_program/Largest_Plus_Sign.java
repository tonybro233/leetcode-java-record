package tony.leetcode.feature.dynamic_program;

import java.util.Arrays;

// 764. 最大加号标志
// 在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，
// 其他每个单元都是 1。网格中包含 1 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。
// 如果未找到加号标志，则返回 0。
//
// 一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心
// 向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。下面给出 k" 阶“轴对称”加号标志的示例。
// 注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。

// k 阶轴对称加号标志示例:
// 阶 1:
// 000
// 010
// 000
//
// 阶 2:
// 00000
// 00100
// 01110
// 00100
// 00000

// 示例 1：
// 输入: N = 5, mines = [[4, 2]]
// 输出: 2

// 解释:
// 11111
// 11111
// 11111
// 11111
// 11011
//
// 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。

public class Largest_Plus_Sign {

    public int orderOfLargestPlusSign2(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for(int[] m : grid) {
            Arrays.fill(m, N);// 初始化为较大值
        }
        for(int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        // 使用l r u d来记录4个方向的累积值
        // 阶数为4个方向最小值，因此先初始化为最大值，计算时直接比较取小
        for(int i = 0; i < N; i++) {
            for(int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));//由左至右
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));//由右至左
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));//由上至下
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));//由下至上
            }
        }
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (N == 0){
            return 0;
        }

        int[][] grid = new int[N][N] ,left = new int[N][N], right = new int[N][N],
                top = new int[N][N], down = new int[N][N];

        for (int i = 0;i < N;i++) {
            for (int j = 0; j < N;j++) {
                grid[i][j] = 1;
            }
        }
        for (int i = 0;i < mines.length;i++) {
            grid[mines[i][0]][mines[i][1]] = 0;
        }

        for (int i = 0;i < N;i++){
            for (int j = 0;j < N;j++){
                if (grid[i][j] != 0) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    top[i][j] = i > 0 ? top[i - 1][j] + 1 : 1;
                }
                if (grid[N-1-i][N-1-j] != 0){
                    right[N-1-i][N-1-j] = j > 0 ? right[N-1-i][N-j] + 1 : 1;
                    down[N-1-i][N-1-j] = i > 0 ? down[N-i][N-1-j] + 1 : 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N;i++){
            for (int j = 0;j < N;j++){
                result = Math.max(result, Math.min(left[i][j], Math.min(right[i][j], Math.min(top[i][j], down[i][j]))));
            }
        }

        return result;
    }

    public static void main(String[] args){
        int i = new Largest_Plus_Sign().orderOfLargestPlusSign(5, new int[][]{{4, 2}});
        System.out.println(i);
    }
}
