package tony.leetcode.feature.dynamic_program;

// 63. 不同路径 II
// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

// 网格中的障碍物和空位置分别用 1 和 0 来表示。
// 说明：m 和 n 的值均不超过 100。

// 示例 1:
// 输入:
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// 输出: 2
// 解释:
// 3x3 网格的正中间有一个障碍物。
// 从左上角到右下角一共有 2 条不同的路径：
// 1. 向右 -> 向右 -> 向下 -> 向下
// 2. 向下 -> 向下 -> 向右 -> 向右

public class Unique_Paths_II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0){
            return 0;
        }
        int m = obstacleGrid[0].length;
        if (m == 0){
            return 0;
        }

        // 考虑起始位置为障碍
        if (obstacleGrid[0][0] == 1){
            return 0;
        }

        int[][] D = new int[n][m];
        D[0][0] = 1;
        for (int i = 0; i < m;i++){
            for (int j = 0; j < n; j++){
                if (obstacleGrid[j][i] != 1){
                    if (j > 0){
                        D[j][i] += D[j-1][i];
                    }
                    if (i > 0){
                        D[j][i] += D[j][i-1];
                    }
                }
            }
        }

        return D[n-1][m-1];
    }

}
