package tony.leetcode.feature.array;

// 498. 对角线遍历
// 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

// 说明:
// 给定矩阵中的元素总数不会超过 100000 。

import java.util.Arrays;

public class Diagonal_Traverse {

    public int[] findDiagonalOrder2(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int idx = 0, rowIdx = 0, colIdx = 0;
        boolean up = true;

        while (idx < result.length) {
            result[idx++] = matrix[rowIdx][colIdx];
            if (up) {
                rowIdx--;
                colIdx++;
            } else {
                rowIdx++;
                colIdx--;
            }

            // 右上角和右边界一致，左下角和下边界一致，所以先判断右和下

            // 右边界
            if (colIdx >= col) {
                colIdx--;
                rowIdx += 2;
                up = !up;
            }
            // 上边界
            else if (rowIdx < 0) {
                rowIdx++;
                up = !up;
            }
            // 下边界
            else if (rowIdx >= row) {
                colIdx += 2;
                rowIdx--;
                up = !up;
            }
            // 左边界
            else if (colIdx < 0) {
                colIdx++;
                up = !up;
            }
        }

        return result;
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0){
            return new int[0];
        }
        int col = matrix[0].length;
        if (col == 0){
            return new int[0];
        }

        int count = row * col;
        int[] result = new int[count];
        int i = 0, j = 0, pos = 0;
        boolean up = true;

        while (true){
            result[pos++] = matrix[i][j];
            if (pos == count){
                break;
            }
            if (up) {
                --i;
                ++j;
                if (j == col){
                    i += 2;
                    j --;
                    up = false;
                } else if (i < 0) {
                    i = 0;
                    up = false;
                }
            } else {
                ++i;
                --j;
                if (i == row){
                    j += 2;
                    i --;
                    up = true;
                } else if (j < 0){
                    j = 0;
                    up = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] diagonalOrder = new Diagonal_Traverse().findDiagonalOrder2(ints);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
