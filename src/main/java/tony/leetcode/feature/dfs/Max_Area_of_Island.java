package tony.leetcode.feature.dfs;

// 695. 岛屿的最大面积
// 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个岛屿
// 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
// 你可以假设二维矩阵的四个边缘都被水包围着。
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
//
// 示例 1:
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
//  [0,0,0,0,0,0,0,1,1,1,0,0,0],
//  [0,1,1,0,1,0,0,0,0,0,0,0,0],
//  [0,1,0,0,1,1,0,0,1,0,1,0,0],
//  [0,1,0,0,1,1,0,0,1,1,1,0,0],
//  [0,0,0,0,0,0,0,0,0,0,1,0,0],
//  [0,0,0,0,0,0,0,1,1,1,0,0,0],
//  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
//
// 示例 2:
// [[0,0,0,0,0,0,0,0]]
// 对于上面这个给定的矩阵, 返回 0。
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。

public class Max_Area_of_Island {

    private int area = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int n1 = grid.length;
        if (n1 == 0) {
            return 0;
        }
        int n2 = grid[0].length;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    dfs(grid, i, j);
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int x, int y) {
        int n1 = grid.length, n2 = grid[0].length;
        if (x < 0 || x >= n1 || y < 0 || y >= n2 || grid[x][y] <= 0) {
            return;
        }
        grid[x][y] = -1;
        area++;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
