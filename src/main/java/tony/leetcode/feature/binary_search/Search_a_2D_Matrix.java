package tony.leetcode.feature.binary_search;

// 74. 搜索二维矩阵
// 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。

// 示例 1:
// 输入:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 3
// 输出: true

public class Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0){
            return false;
        }
        int col = matrix[0].length;
        if (col == 0){
            // 注意有可能n行0列
            return false;
        }
        int minrow = 0, hirow = row-1;
        while (minrow <= hirow){
            int mid = minrow + (hirow - minrow)/2;
            if (matrix[mid][0] == target){
                return true;
            } else if (matrix[mid][0] > target){
                hirow = mid - 1;
            } else {
                minrow = mid + 1;
            }
        }
        if (hirow < 0){
            // 比matrix[0][0]还要小
            return false;
        }
        int mincol = 0, hicol = col - 1;
        while (mincol <= hicol){
            int mid = mincol + (hicol - mincol)/2;
            if (matrix[hirow][mid] == target){
                return true;
            } else if (matrix[hirow][mid] > target){
                hicol = mid - 1;
            } else {
                mincol = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[][] ints = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] ints1 = {{1}};
        boolean b = new Search_a_2D_Matrix().searchMatrix(ints1, 0);
        System.out.println(b);
    }
}
