package tony.leetcode.feature.dfs;

import java.util.ArrayList;
import java.util.List;

// 417. 太平洋大西洋水流问题
// 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。
// “太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
//
// 提示：
//     输出坐标的顺序不重要
//     m 和 n 都小于150
//
// 示例：
// 给定下面的 5x5 矩阵:
//
//   太平洋 ~   ~   ~   ~   ~
//        ~  1   2   2   3  (5) *
//        ~  3   2   3  (4) (4) *
//        ~  2   4  (5)  3   1  *
//        ~ (6) (7)  1   4   5  *
//        ~ (5)  1   1   2   4  *
//           *   *   *   *   * 大西洋
//
// 返回:
//
// [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).


public class Pacific_Atlantic_Water_Flow {

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (null == matrix || matrix.length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        // 分别从边界逆向搜索可达坐标
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
        // x、y增量数组表示上下左右移动
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, i, 0, Integer.MIN_VALUE, dirs);
            dfs(matrix, atlantic, i, n - 1, Integer.MIN_VALUE, dirs);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, 0, i, Integer.MIN_VALUE, dirs);
            dfs(matrix, atlantic, m - 1, i, Integer.MIN_VALUE, dirs);
        }
        // 从边上逆向都可达的点满足要求
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }

    private void dfs(int[][] matrix, boolean[][] mark, int x, int y, int from, int[][] dirs) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length
                || mark[x][y] || matrix[x][y] < from) {
            return;
        }
        mark[x][y] = true;
        for (int[] dir : dirs) {
            dfs(matrix, mark, x + dir[0], y + dir[1], matrix[x][y], dirs);
        }
    }
}
