package tony.leetcode.feature.array;

import java.util.ArrayList;
import java.util.List;

// 54. 螺旋矩阵
// 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
// 示例 1:
// 输入:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// 输出: [1,2,3,6,9,8,7,4,5]

// 示例 2:
// 输入:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// 输出: [1,2,3,4,8,12,11,10,9,5,6,7]

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        // 维护4个值作为范围，按照向右、向下、向左、向上的顺序循环
        int top = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            if (left > right) {
                break;
            }
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            if (top > down) {
                break;
            }
            for (int i = top; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down--;

            if (top > down) {
                break;
            }
            for (int i = down; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}
