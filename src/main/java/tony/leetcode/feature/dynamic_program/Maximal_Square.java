package tony.leetcode.feature.dynamic_program;

// 221 最大正方形
// 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
//
// 输出: 4

public class Maximal_Square {

    public int maximalSquare(char[][] matrix) {
        if (null == matrix || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] D = new int[row][col];
        int max = 0;
        for (int i = 0;i < row; i++){
            for (int j = 0; j < col;j++){
                if (matrix[i][j] == '0'){
                    continue;
                }
                if (i > 0 && j > 0){
                    // 这个转移方程。。。有点秀
                    int val = Math.min(D[i][j-1], D[i-1][j]);
                    val = Math.min(val,  D[i-1][j-1]);
                    D[i][j] = ++val;
                } else {
                    // 注意给边界赋值
                    D[i][j] = 1;
                }
                max = Math.max(max, D[i][j]);
            }
        }

        return max*max;
    }
}
