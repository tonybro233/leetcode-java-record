package tony.sword_to_offer;

// 29. 顺时针打印矩阵
// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
// 示例 1：
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,3,6,9,8,7,4,5]

// 示例 2：
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// 输出：[1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.Arrays;

public class _29_spiral_matrix {

    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return new int[0];
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int idx = 0;

        int left = 0, right = col - 1, top = 0, bottom = row - 1;

        while (true) {
            // 上
            for (int i = left; i <= right;i++) {
                result[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }

            // 右
            for (int i = top; i <= bottom; i++) {
                result[idx++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }

            // 下
            for (int i = right; i >= left;i--) {
                result[idx++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }

            // 左
            for (int i = bottom; i >= top;i--) {
                result[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = new _29_spiral_matrix().spiralOrder(new int[][]{{7, 9, 6}});
        System.out.println(Arrays.toString(ints));
    }

}
