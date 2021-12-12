package tony.leetcode.feature.binary_search;

// 240 搜索二维矩阵 II
// 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
//
// 每行的元素从左到右升序排列。
// 每列的元素从上到下升序排列。

// 示例:
// 现有矩阵 matrix 如下：
//
// [
//   [1,   4,  7, 11, 15],
//   [2,   5,  8, 12, 19],
//   [3,   6,  9, 16, 22],
//   [10, 13, 14, 17, 24],
//   [18, 21, 23, 26, 30]
// ]

// 给定 target = 5，返回 true。
// 给定 target = 20，返回 false。

public class Search_2D_Matrix_II {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] < target) {
                    break;
                } else if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从左下角开始
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int i, j;
        for (i = rowCount - 1, j = 0; i >= 0 && j < colCount; ) {
            if (target == matrix[i][j]) {
                return true;
            }
            if (target < matrix[i][j]) {
                i--;
                continue;
            }
            if (target > matrix[i][j]) {
                j++;
                continue;
            }
        }
        return false;
    }
}
