package tony.leetcode.feature.bfs;

import java.util.Deque;
import java.util.LinkedList;

// 542. 01 矩阵
// 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
// 两个相邻元素间的距离为 1 。
//
// 示例 1:
// 输入:
// 0 0 0
// 0 1 0
// 0 0 0
// 输出:
// 0 0 0
// 0 1 0
// 0 0 0

// 示例 2:
// 输入:
// 0 0 0
// 0 1 0
// 1 1 1
// 输出:
// 0 0 0
// 0 1 0
// 1 2 1

// 注意:
// 给定矩阵的元素个数不超过 10000。
// 给定矩阵中至少有一个元素是 0。
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。

public class _01_Matrix {

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] result = new int[row][col];
        Deque<Integer> rowque = new LinkedList<>(), colque = new LinkedList<>();
        int round = 1, count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowque.addLast(i);
                    colque.addLast(j);
                    count++;
                }
            }
        }
        while (null != rowque.peekFirst()) {
            int tmp = 0;
            for (int i = 0; i < count; i++) {
                Integer x = rowque.pollFirst();
                Integer y = colque.pollFirst();
                try {
                    if (matrix[x - 1][y] == 1 && result[x - 1][y] == 0) {
                        result[x - 1][y] = round;
                        rowque.addLast(x - 1);
                        colque.addLast(y);
                        tmp++;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) { }
                try {
                    if (matrix[x + 1][y] == 1 && result[x + 1][y] == 0) {
                        result[x + 1][y] = round;
                        rowque.addLast(x + 1);
                        colque.addLast(y);
                        tmp++;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) { }
                try {
                    if (matrix[x][y - 1] == 1 && result[x][y - 1] == 0) {
                        result[x][y - 1] = round;
                        rowque.addLast(x);
                        colque.addLast(y - 1);
                        tmp++;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) { }
                try {
                    if (matrix[x][y + 1] == 1 && result[x][y + 1] == 0) {
                        result[x][y + 1] = round;
                        rowque.addLast(x);
                        colque.addLast(y + 1);
                        tmp++;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) { }
            }
            count = tmp;
            round++;
        }

        return result;
    }
}
