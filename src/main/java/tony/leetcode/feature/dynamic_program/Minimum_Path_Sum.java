package tony.leetcode.feature.dynamic_program;

// 64. 最小路径和
// 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
// 输入:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// 输出: 7
// 解释: 因为路径 1→3→1→1→1 的总和最小。

public class Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] D = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // 注意处理下0,0点
                    D[i][j] = grid[i][j];
                } else {
                    int top = i == 0 ? Integer.MAX_VALUE : D[i - 1][j];
                    int left = j == 0 ? Integer.MAX_VALUE : D[i][j - 1];
                    D[i][j] = Math.min(top, left) + grid[i][j];
                }
            }
        }

        return D[m - 1][n - 1];
    }
}
